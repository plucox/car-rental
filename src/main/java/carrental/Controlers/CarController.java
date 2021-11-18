package carrental.Controlers;

import carrental.Models.Car;
import carrental.Models.CarDetails;
import carrental.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> getAllCars(){
        return carService.getAllCars().stream().collect(Collectors.toList());
    }

    @GetMapping("/getByID")
    public Car getCar(@RequestParam(value = "idCar") String idCar){
        return carService.getCarByID(idCar);
    }

    @PostMapping("/add")
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @DeleteMapping("/delete")
    public Car deleteCar(@RequestParam(value = "idCar") String idCar){
        return carService.deleteCar(idCar);
    }

    @GetMapping("/details")
    public CarDetails getCarDetails(@RequestParam(value = "idCar") String idCar){
        return carService.getCarDetails(idCar);
    }

    @PostMapping("/add-details")
    public CarDetails setCarDetails(@RequestParam(value = "idCar") String idCar,
                       @RequestBody CarDetails carDetails){
        return carService.setCarDetails(idCar, carDetails);
    }

    @PatchMapping("/update-details")
    public CarDetails updateCarDetails(@RequestParam(value = "idCar") String idCar,
                                       @RequestBody CarDetails carDetails){
        return carService.updateCarDetails(idCar, carDetails);
    }


}
