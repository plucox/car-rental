package carrental.Controlers;

import carrental.Converter.CarConverter;
import carrental.Converter.CarDetailsConverter;
import carrental.DTO.CarDTO;
import carrental.DTO.CarDetailsDTO;
import carrental.Models.Car;
import carrental.Models.CarDetails;
import carrental.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<CarDTO> getAllCars(){
        return CarConverter.entityToDTO(carService.getAllCars());
    }

    @GetMapping("/all-available")
    public List<CarDTO> getAllAvailableCars(@RequestParam(value = "dateFrom") String dateFrom,
                                         @RequestParam(value = "dateTo") String dateTo) throws ParseException {
        return CarConverter.entityToDTO(carService.getAllAvailableCars(dateFrom,dateTo));
    }

    @GetMapping("/getById")
    public CarDTO getCar(@RequestParam(value = "idCar") String idCar){
        return CarConverter.entityToDTO(carService.getCarByID(idCar));
    }

    @PostMapping("/add")
    public CarDTO addCar(@RequestBody Car car){
        return CarConverter.entityToDTO(carService.addCar(car));
    }

    @DeleteMapping("/delete")
    public CarDTO deleteCar(@RequestParam(value = "idCar") String idCar){
        return CarConverter.entityToDTO(carService.deleteCar(idCar));
    }

    @GetMapping("/details")
    public CarDetailsDTO getCarDetails(@RequestParam(value = "idCar") String idCar){
        return CarDetailsConverter.entityToDTO(carService.getCarDetails(idCar));
    }

    @PostMapping("/add-details")
    public CarDetailsDTO setCarDetails(@RequestParam(value = "idCar") String idCar,
                       @RequestBody CarDetails carDetails){
        return CarDetailsConverter.entityToDTO(carService.setCarDetails(idCar, carDetails));
    }

    @PatchMapping("/update-details")
    public CarDetailsDTO updateCarDetails(@RequestParam(value = "idCar") String idCar,
                                       @RequestBody CarDetails carDetails){
        return CarDetailsConverter.entityToDTO(carService.updateCarDetails(idCar, carDetails));
    }


}
