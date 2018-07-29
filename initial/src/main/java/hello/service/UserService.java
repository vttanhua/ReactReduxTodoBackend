package hello.service;

import hello.repository.UserRepository;
import hello.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Example;
import java.util.List;

import static java.lang.String.format;
import static java.util.Collections.emptyList;

@Service
public class UserService implements UserDetailsService {

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

    public User getByUserName(String userName){
        User u = new User();
        u.setUsername(userName);
        Example<User> eu =  Example.of(u);
        return this.getByExample(eu);
    }

    public User Authenticate(String userName, String password) {
        User u = null;
        try{
            u = this.getByUserName(userName);

        }catch (IllegalArgumentException ie){

        }
        return u;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User u = getByUserName(userName);
        if(u == null)
            throw new UsernameNotFoundException(userName);
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), emptyList());
    }
}
