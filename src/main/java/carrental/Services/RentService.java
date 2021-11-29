package carrental.Services;

import carrental.Exception.ResourceNotFoundException;
import carrental.Models.Car;
import carrental.Models.Rent;
import carrental.Models.User;
import carrental.Repositories.RentRepository;
import carrental.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RentService {
    private final RentRepository rentRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final CarService carService;


    @Autowired
    public RentService(RentRepository rentRepository, UserService userService, UserRepository userRepository, @Lazy CarService carService) {
        this.rentRepository = rentRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.carService = carService;
    }


    public Rent addRent(String userId, String carId, Rent rent){
       User user = userService.getUserById(userId);
       Car car = carService.getCarByID(carId);
       if(user!=null){
           rent.setCar(car);
           rent.setUser(user);
           user.addRent(rent);
           rentRepository.save(rent);
           userRepository.save(user);
       }
        return rent;
    }

    public List<Rent> getAllRents(){
        return rentRepository.findAll();
    }

    public List<Rent> getAllUserRents(String userId){
        return userService.getUserById(userId).getRents();
    }

    public Rent getRentById(String rentId){
        return rentRepository.findById(rentId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found given rent Id: "+rentId));
    }

    public User deleteRent(String userId, String rentId){
        User user = userService.getUserById(userId);
        List<Rent> rents = user.getRents();
        for(int i=0; i<rents.size(); i++){
            if(rents.get(i).get_id().equals(rentId)){
                rents.remove(i);
                break;
            }
        }
        Rent rent = getRentById(rentId);
        rentRepository.delete(rent);
        user.setRents(rents);
        userRepository.save(user);
        return user;
    }
}
