package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Floor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FloorRepository extends MongoRepository<Floor, String> {

}
