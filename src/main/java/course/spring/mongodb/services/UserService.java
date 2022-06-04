package course.spring.mongodb.services;

import course.spring.mongodb.domain.User;
import course.spring.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAll(){
        return this.userRepository.findAll();
    }
    
}