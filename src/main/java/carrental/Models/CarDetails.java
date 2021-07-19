package carrental.Models;

public class CarDetails {
    private String engine;
    private String fuelType;
    private Integer horsePower;
    private Integer yearOfProduction;
    private String color;
    private Integer seats;
    private String description;

    public CarDetails() {
    }

    public CarDetails(String engine, String fuelType, Integer horsePower, Integer yearOfProduction, String color, Integer seats, String description) {
        this.engine = engine;
        this.fuelType = fuelType;
        this.horsePower = horsePower;
        this.yearOfProduction = yearOfProduction;
        this.color = color;
        this.seats = seats;
        this.description = description;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
