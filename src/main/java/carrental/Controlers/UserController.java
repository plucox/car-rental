package carrental.Controlers;

import carrental.Models.Rent;
import carrental.Models.User;
import carrental.Services.RentService;
import carrental.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RentService rentService;

    @Autowired
    public UserController(UserService userService, RentService rentService) {
        this.userService = userService;
        this.rentService = rentService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers().stream().collect(Collectors.toList());
    }

    @GetMapping("/getByID")
    public User getUserById(@RequestParam(value = "userId") String userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/delete-user")
    public User deleteUSer(@RequestParam(value = "userId") String userId){
        return userService.deleteUser(userId);
    }

    @PatchMapping("/update")
    public User updateUser(@RequestParam(value = "userId") String userId,
                           @RequestBody User user){
        return userService.updateUser(userId,user);
    }

    @GetMapping("/getAllUserRents")
    public List<Rent> getAllUserRents(@RequestParam(value = "userId") String userId){
        return rentService.getAllUserRents(userId);
    }

    @GetMapping("/getRentById")
    public Rent getRentbyId(@RequestParam(value = "rentId") String rentId){
        return rentService.getRentById(rentId);
    }

    @PatchMapping("/attach-rent")
    public Rent attachRentToUser(@RequestParam(value = "userId") String userId,
                                 @RequestBody Rent rent){
        return rentService.addRent(userId, rent);
    }

    @PatchMapping("/detach-rent")
    public User detachRentFromUser(@RequestParam(value = "userId") String userId,
                                   @RequestParam(value = "rentId") String rentId){
        return rentService.deleteRent(userId,rentId);
    }

}
