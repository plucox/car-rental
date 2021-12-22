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
    private String username;
    private String email;
    private List<Rent> rents;

    public void setRents(List<Rent> rents) {
        this.rents = new ArrayList<>();
    }
}
