package carrental.Controlers;

import carrental.Models.Car;
import carrental.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> getAllCars(){
        return carService.getAllCars().stream().collect(Collectors.toList());
    }

    @PostMapping
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }
}
