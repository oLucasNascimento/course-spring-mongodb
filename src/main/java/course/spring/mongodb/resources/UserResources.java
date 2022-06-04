package course.spring.mongodb.resources;

import course.spring.mongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResources {
    
    @GetMapping
    public ResponseEntity findAll() {
        
        User maria = new User(1, "Maria Brown", "maria@gmail.com");
        User alex = new User(2, "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        
        return ResponseEntity.ok().body(list);
    }
    
}