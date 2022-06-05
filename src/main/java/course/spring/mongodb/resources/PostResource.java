package course.spring.mongodb.resources;

import course.spring.mongodb.domain.Post;
import course.spring.mongodb.domain.User;
import course.spring.mongodb.dto.UserDTO;
import course.spring.mongodb.resources.util.URL;
import course.spring.mongodb.services.PostService;
import course.spring.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {
    
    @Autowired
    private PostService postService;
    
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        Post post = this.postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
    
    @GetMapping("/titlesearch")
    public ResponseEntity findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = this.postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
    
}