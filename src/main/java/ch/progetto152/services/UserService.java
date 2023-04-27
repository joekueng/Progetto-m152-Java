package ch.progetto152.services;


import ch.progetto152.entity.UserEntity;
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

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserByIdService(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity getUserByNameService(String name){
        return userRepository.findUserByName(name).orElse(null);
    }

    public UserEntity getUserByUsernameService(String username){
        return userRepository.findUserByUsername(username).orElse(null);
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity user1 = getUserByIdService(id);
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
