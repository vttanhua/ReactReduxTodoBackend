package hello.service;

import hello.repository.UserRepository;
import hello.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    public User getUserById(Long id){
        return this.userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(format("UserEntity not found with id %s", id)));
    }

    public User createOrUpdateUser(User user){
        return this.userRepository.save(user);
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }


}
