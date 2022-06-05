package course.spring.mongodb.config;

import course.spring.mongodb.domain.Post;
import course.spring.mongodb.domain.User;
import course.spring.mongodb.dto.AuthorDTO;
import course.spring.mongodb.dto.CommentDTO;
import course.spring.mongodb.repositories.PostRepository;
import course.spring.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PostRepository postRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        this.userRepository.deleteAll();
        this.postRepository.deleteAll();
        
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
    
        this.userRepository.saveAll(Arrays.asList(maria, alex, bob));
    
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));
    
        CommentDTO comment1 = new CommentDTO("Boa viagem, mano!", sdf.parse("21/03/2018"),new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"),new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"),new AuthorDTO(alex));
        
        post1.getComments().addAll(Arrays.asList(comment1,comment2));
        post2.getComments().add(comment3);
        
        this.postRepository.saveAll(Arrays.asList(post1, post2));
        
        maria.getPosts().addAll(Arrays.asList(post1,post2));
        this.userRepository.save(maria);
        
    }
}