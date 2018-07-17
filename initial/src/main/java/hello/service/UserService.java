package hello.service;

import hello.repository.UserRepository;
import hello.entity.User;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Example;
import java.util.List;

import static java.lang.String.format;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getById(Long id){
        return this.userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(format("UserEntity not found with id %s", id)));
    }

    public User createOrUpdate(User user){
        return this.userRepository.save(user);
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public User getByExample(Example<User> user){
        return this.userRepository.findOne(user).orElseThrow(() -> new IllegalArgumentException(format("UserEntity not found with Example %s", user)));
    }

    public User getByUserNameAndPassword(String userName, String password){
        ///TODO Password should be crypted
        User u = new User();
        u.setUserName(userName);
        u.setPassword(password);
        Example<User> eu =  Example.of(u);
        return this.getByExample(eu);
    }


}