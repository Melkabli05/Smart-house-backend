package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);



}
