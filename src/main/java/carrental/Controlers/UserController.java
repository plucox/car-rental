package carrental.Controlers;

import carrental.Models.User;
import carrental.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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




}
