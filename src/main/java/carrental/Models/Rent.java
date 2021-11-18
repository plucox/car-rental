package carrental.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rents")
public class Rent {
    @Id
    private String _id;
    @DBRef
    private Car car;
    private String dateFrom;
    private String dateTo;

    public Rent() {
    }

    public Rent(String _id, Car car, String dateFrom, String dateTo) {
        this._id = _id;
        this.car = car;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
