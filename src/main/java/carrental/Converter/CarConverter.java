package carrental.Converter;

import carrental.DTO.CarDTO;
import carrental.Models.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarConverter {
    public static CarDTO entityToDTO(Car entity){
        CarDTO dto = new CarDTO();
        dto.set_id(entity.get_id());
        dto.setMark(entity.getMark());
        dto.setModel(entity.getModel());
        dto.setType(entity.getType());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public static List<CarDTO> entityToDTO(List<Car> car){
        return car.stream().map(CarConverter::entityToDTO).collect(Collectors.toList());
    }

}
