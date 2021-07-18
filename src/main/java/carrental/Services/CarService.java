package carrental.Services;

import carrental.Models.Car;
import carrental.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car addCar(Car car){
        return carRepository.save(car);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

}
