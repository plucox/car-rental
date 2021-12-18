package carrental.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDetailsDTO {
    private String engine;
    private String fuelType;
    private Integer horsePower;
    private Integer yearOfProduction;
    private String color;
    private Integer seats;
    private String description;
}
