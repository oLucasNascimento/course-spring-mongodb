package course.spring.mongodb.services;

import course.spring.mongodb.domain.Post;
import course.spring.mongodb.repositories.PostRepository;
import course.spring.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    public Post findById(String id) {
        Optional<Post> post = this.postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found!"));
    }
    
    public List<Post> findByTitle(String text){
        return this.postRepository.findByTitleContainingIgnoreCase(text);
    }

}