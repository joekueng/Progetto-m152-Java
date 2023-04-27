package ch.progetto152.services;


import ch.progetto152.entity.User;
import ch.progetto152.repository.UserRepository;
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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByIdService(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByNameService(String name){
        return userRepository.findUserByName(name).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User user1 = getUserByIdService(id);
        if (user1 != null) {
            user1.setName(user.getName());
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
            return userRepository.save(user1);
        } else {
            return null;
        }
    }

    public boolean deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if(!exists){
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
