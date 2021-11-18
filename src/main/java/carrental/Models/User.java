package carrental.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "users")
public class User {
    @Id
    private String _id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private String phoneNum;
    private Integer age;
    @DBRef
    private List<Rent> rents;

    public User() {
    }

    public User(String _id, String firstName, String lastName, String email, String phoneNum, Integer age, List<Rent> rents) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.age = age;
        this.rents = rents;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Rent> getRents() {
        return rents == null ? new ArrayList<>() : rents;
    }

    public void addRent(Rent rent){
        if(rents == null)
            rents = new ArrayList<>();
        rents.add(rent);
    }

    public List<Rent> deleteRent(Rent rent){
        if(rents == null)
            rents = new ArrayList<>();
        rents.remove(rent);
        return rents;
    }

    public void setRents(List<Rent> rentsToSet){
        this.rents = rentsToSet;
    }
}
