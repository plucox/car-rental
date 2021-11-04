package carrental.Services;

import carrental.Exception.ResourceNotFoundException;
import carrental.Models.Car;
import carrental.Models.CarDetails;
import carrental.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car){
        return carRepository.save(car);
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
