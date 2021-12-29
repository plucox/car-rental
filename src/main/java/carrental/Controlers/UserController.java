package carrental.Controlers;

import carrental.Converter.RentConverter;
import carrental.Converter.UserConverter;
import carrental.DTO.RentDTO;
import carrental.DTO.UserDTO;
import carrental.Models.Rent;
import carrental.Models.User;
import carrental.Services.RentService;
import carrental.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    private final UserService userService;
    private final RentService rentService;

    @Autowired
    public UserController(UserService userService, RentService rentService) {
        this.userService = userService;
        this.rentService = rentService;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return UserConverter.entityToDTO(userService.getAllUsers());
    }

    @GetMapping("/getByID")
    public UserDTO getUserById(@RequestParam(value = "userId") String userId){
        return UserConverter.entityToDTO(userService.getUserById(userId));
    }

    @PostMapping("/add")
    public UserDTO addUser(@RequestBody User user){
        return UserConverter.entityToDTO(userService.addUser(user));
    }

    @DeleteMapping("/delete-user")
    public UserDTO deleteUSer(@RequestParam(value = "userId") String userId){
        return UserConverter.entityToDTO(userService.deleteUser(userId));
    }

//    @PatchMapping("/update")
//    public UserDTO updateUser(@RequestParam(value = "userId") String userId,
//                           @RequestBody User user){
//        return UserConverter.entityToDTO(userService.updateUser(userId,user));
//    }


    @GetMapping("/getAllRents")
    public List<RentDTO> getAllRents(){
        return RentConverter.entityToDTO(rentService.getAllRents());
    }

    @GetMapping("/getAllUserRents")
    public List<RentDTO> getAllUserRents(@RequestParam(value = "userId") String userId){
        return RentConverter.entityToDTO(rentService.getAllUserRents(userId));
    }

    @GetMapping("/getRentById")
    public RentDTO getRentbyId(@RequestParam(value = "rentId") String rentId){
        return RentConverter.entityToDTO(rentService.getRentById(rentId));
    }

    @PatchMapping("/attach-rent")
    public RentDTO attachRentToUser(@RequestParam(value = "userId") String userId,
                                 @RequestParam(value = "carId") String carId,
                                 @RequestBody Rent rent){
        return RentConverter.entityToDTO(rentService.addRent(userId, carId, rent));
    }

    @PatchMapping("/detach-rent")
    public UserDTO detachRentFromUser(@RequestParam(value = "userId") String userId,
                                   @RequestParam(value = "rentId") String rentId){
        return UserConverter.entityToDTO(rentService.deleteRent(userId,rentId));
    }

}
