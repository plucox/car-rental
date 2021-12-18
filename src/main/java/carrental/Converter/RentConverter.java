package carrental.Converter;

import carrental.DTO.RentDTO;
import carrental.Models.Rent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentConverter {
    public static RentDTO entityToDTO(Rent entity){
        RentDTO dto = new RentDTO();
        dto.set_id(entity.get_id());
        dto.setCar(entity.getCar());
        dto.setDateFrom(entity.getDateFrom());
        dto.setDateTo(entity.getDateTo());
        return dto;
    }

    public static List<RentDTO> entityToDTO(List<Rent> rent){
        return rent.stream().map(RentConverter::entityToDTO).collect(Collectors.toList());
    }
}
