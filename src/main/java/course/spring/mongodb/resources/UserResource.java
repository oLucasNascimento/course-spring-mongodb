package course.spring.mongodb.resources;

import course.spring.mongodb.domain.User;
import course.spring.mongodb.dto.UserDTO;
import course.spring.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity insertUser(@RequestBody UserDTO newUserDto){
        User newUser = this.userService.fromDto(newUserDto);
        newUser = this.userService.insertUser(newUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @GetMapping
    public ResponseEntity findAll() {
        List<User> list = this.userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        User user = this.userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable String id, @RequestBody UserDTO userDto){
        User newUser = this.userService.fromDto(userDto);
        newUser.setId(id);
        newUser = this.userService.updateUser(newUser);
        return ResponseEntity.noContent().build();
    }
    
}