package course.spring.mongodb.resources;

import course.spring.mongodb.domain.User;
import course.spring.mongodb.dto.UserDTO;
import course.spring.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public ResponseEntity findAll() {
        List<User> list = this.userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }
    
}