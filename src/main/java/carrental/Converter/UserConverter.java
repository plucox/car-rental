package carrental.Converter;

import carrental.DTO.UserDTO;
import carrental.Models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public static UserDTO entityToDTO(User entity){
        UserDTO dto = new UserDTO();
        dto.set_id(entity.get_id());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNum(entity.getPhoneNum());
        dto.setAge(entity.getAge());
        dto.setRents(entity.getRents());
        return dto;
    }

    public static List<UserDTO> entityToDTO(List<User> user){
        return user.stream().map(UserConverter::entityToDTO).collect(Collectors.toList());
    }
}
