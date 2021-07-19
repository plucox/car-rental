package carrental.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "rents")
public class Rent {
    @Id
    private String _id;
    @DBRef
    private Car car;
    private Date dateFrom;
    private Date dateTo;

    public Rent() {
    }

    public Rent(String _id, Car car, Date dateFrom, Date dateTo) {
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
