package carrental.Converter;

import carrental.DTO.CarDetailsDTO;
import carrental.Models.CarDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDetailsConverter {
    public static CarDetailsDTO entityToDTO(CarDetails entity){
        CarDetailsDTO dto = new CarDetailsDTO();
        dto.setEngine(entity.getEngine());
        dto.setFuelType(entity.getFuelType());
        dto.setHorsePower(entity.getHorsePower());
        dto.setYearOfProduction(entity.getYearOfProduction());
        dto.setColor(entity.getColor());
        dto.setSeats(entity.getSeats());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public static List<CarDetailsDTO> entityToDTO(List<CarDetails> carDetails){
        return carDetails.stream().map(CarDetailsConverter::entityToDTO).collect(Collectors.toList());
    }
}
