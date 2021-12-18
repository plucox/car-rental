package carrental.DTO;

import carrental.Models.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDTO {
    private String _id;
    private Car car;
    private String dateFrom;
    private String dateTo;

    public void setCar(Car car) {
        this.car = car;
        this.car.setCarDetails(null);
    }
}
