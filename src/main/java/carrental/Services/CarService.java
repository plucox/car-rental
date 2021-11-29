package carrental.Services;

import carrental.Exception.ResourceNotFoundException;
import carrental.Models.Car;
import carrental.Models.CarDetails;
import carrental.Models.Rent;
import carrental.Models.User;
import carrental.Repositories.CarRepository;
import carrental.Repositories.RentRepository;
import carrental.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final RentService rentService;
    private final RentRepository rentRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public CarService(CarRepository carRepository, RentService rentService, RentRepository rentRepository, UserRepository userRepository, UserService userService) {
        this.carRepository = carRepository;
        this.rentService = rentService;
        this.rentRepository = rentRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public Car addCar(Car car){
        return carRepository.save(car);
    }

    public Car deleteCar(String idCar){
        Car car = getCarByID(idCar);
        List<Rent> rents = rentService.getAllRents();
        for (Rent rent : rents) {
            if (rent.getCar().get_id().equals(idCar)) {
                rentService.deleteRent(rent.getUser().get_id(), rent.get_id());
            }
        }
        carRepository.delete(car);
        return car;
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car getCarByID(String idCar){
        return carRepository.findById(idCar)
                .orElseThrow(() -> new ResourceNotFoundException("Not found given id car: "+idCar));
    }

    public CarDetails getCarDetails(String idCar){
        return getCarByID(idCar).getCarDetails();
    }

    public CarDetails setCarDetails(String idCar, CarDetails carDetails){
        Car car = getCarByID(idCar);
        car.setCarDetails(carDetails);
        carRepository.save(car);
        return car.getCarDetails();
    }

    public CarDetails updateCarDetails(String idCar, CarDetails carDetails){
        Car car = getCarByID(idCar);
        CarDetails oldCarDetails = car.getCarDetails();

        if(carDetails.getColor() != null)
            oldCarDetails.setColor(carDetails.getColor());
        if(carDetails.getDescription() != null)
            oldCarDetails.setDescription(carDetails.getDescription());
        if(carDetails.getEngine() != null)
            oldCarDetails.setEngine(carDetails.getEngine());
        if(carDetails.getSeats() != null)
            oldCarDetails.setSeats(carDetails.getSeats());
        if(carDetails.getFuelType() != null)
            oldCarDetails.setFuelType(carDetails.getFuelType());
        if(carDetails.getHorsePower() != null)
            oldCarDetails.setHorsePower(carDetails.getHorsePower());
        if(carDetails.getYearOfProduction() != null)
            oldCarDetails.setYearOfProduction(carDetails.getYearOfProduction());

        car.setCarDetails(oldCarDetails);
        carRepository.save(car);
        return car.getCarDetails();
    }

}
