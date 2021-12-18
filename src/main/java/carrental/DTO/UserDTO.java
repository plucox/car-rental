package carrental.DTO;

import carrental.Models.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String _id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private Integer age;
    private List<Rent> rents;

    public void setRents(List<Rent> rents) {
        this.rents = new ArrayList<>();
    }
}
