package carrental.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "rents")
public class Rent {
    @Id
    private String _id;
    private String carId;
    private Date dateFrom;
    private Date dateTo;

    public Rent() {
    }

    public Rent(String _id, String carId, Date dateFrom, Date dateTo) {
        this._id = _id;
        this.carId = carId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
