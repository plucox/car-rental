package carrental.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String _id;
    private String mark;
    private String model;
    private String type;
    private Integer price;
}
