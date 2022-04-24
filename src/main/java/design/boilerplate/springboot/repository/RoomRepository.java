package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {


}
