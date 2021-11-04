package carrental.Services;

import carrental.Exception.ResourceNotFoundException;
import carrental.Models.Car;
import carrental.Models.Rent;
import carrental.Repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {
    private final RentRepository rentRepository;
    private final CarService carService;

    @Autowired
    public RentService(RentRepository rentRepository, CarService carService) {
        this.rentRepository = rentRepository;
        this.carService = carService;
    }


    public Rent addRent(Rent rent){
        Car car = carService.getCarByID(rent.getCarId());
        if(car!=null)
            return rentRepository.save(rent);
        else throw new ResourceNotFoundException("Not found car with given Id car: "+rent.getCarId());
    }


}
