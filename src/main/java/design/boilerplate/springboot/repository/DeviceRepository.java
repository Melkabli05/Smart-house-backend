package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository<Device, String> {


}
