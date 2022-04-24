package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.House;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HouseRepository extends MongoRepository<House, String> {

}
