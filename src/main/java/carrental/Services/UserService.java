package carrental.Services;

import carrental.Exception.ResourceNotFoundException;
import carrental.Models.User;
import carrental.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String idUser){
        return userRepository.findById(idUser).
                orElseThrow(() -> new ResourceNotFoundException("Not found given id user: "+idUser));
    }


}
