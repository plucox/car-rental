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
    private String PhoneNum;
    private Integer Age;
    @DBRef
    private List<Rent> rents;

    public User() {
    }

    public User(String _id, String firstName, String lastName, String email, String phoneNum, Integer age, List<Rent> rents) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        PhoneNum = phoneNum;
        Age = age;
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
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public List<Rent> getRents() {
        return rents == null ? new ArrayList<>() : rents;
    }

    public List<Rent> addRent(Rent rent){
        if(rents == null)
            rents = new ArrayList<>();
        rents.add(rent);
        return rents;
    }
}
