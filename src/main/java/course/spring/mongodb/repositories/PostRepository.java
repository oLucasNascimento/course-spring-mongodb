package course.spring.mongodb.repositories;

import course.spring.mongodb.domain.Post;
import course.spring.mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}