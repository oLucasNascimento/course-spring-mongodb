package course.spring.mongodb.services;

import course.spring.mongodb.domain.User;
import course.spring.mongodb.repositories.UserRepository;
import course.spring.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    
    public User findById(String id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }
    
}