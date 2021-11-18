package carrental.Services;

import carrental.Exception.ResourceNotFoundException;
import carrental.Models.Rent;
import carrental.Models.User;
import carrental.Repositories.RentRepository;
import carrental.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RentRepository rentRepository;

    @Autowired
    public UserService(UserRepository userRepository, RentRepository rentRepository) {
        this.userRepository = userRepository;
        this.rentRepository = rentRepository;
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

    public User updateUser(String userId, User user) {
        User oldUser = getUserById(userId);

        if(user.getAge()!=null)
            oldUser.setAge(user.getAge());
        if(user.getEmail()!=null)
            oldUser.setEmail(user.getEmail());
        if(user.getFirstName()!=null)
            oldUser.setFirstName(user.getFirstName());
        if(user.getLastName()!=null)
            oldUser.setLastName(user.getLastName());
        if(user.getPhoneNum()!=null)
            oldUser.setPhoneNum(user.getPhoneNum());

        userRepository.save(oldUser);
        return oldUser;
    }
    //TODO delete user rents
    public User deleteUser(String userId){
        User user = getUserById(userId);
        userRepository.delete(user);
        return user;
    }

}
