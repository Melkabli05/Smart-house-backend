package test.design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Device;
import design.boilerplate.springboot.model.DeviceStatus;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.model.UserRole;
import design.boilerplate.springboot.repository.DeviceRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Profiles;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DeviceRepositoryTest {


    @Autowired
     MongoTemplate mongoTemplate;


    Device entity = new Device();

    @BeforeEach
    void setUp() {
        entity.setId("123");
        entity.setName("device");
        entity.setStatus(DeviceStatus.ON);
        entity.setRoom(null);
        mongoTemplate.save(entity);

    }
    @AfterEach
    void cleanUpDatabase() {
        mongoTemplate.remove(entity);
    }






    @Test
    void add() {
        mongoTemplate.save(entity);
        Device foundDevice = mongoTemplate.findById(entity.getId(), Device.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }

    @Test
    void getAll() {
        assertNotNull(mongoTemplate.findAll(Device.class));
        assertEquals(1, mongoTemplate.findAll(Device.class).size());

    }

    @Test
    void findById() {

        Device foundDevice = mongoTemplate.findById(entity.getId(), Device.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

     }

    @Test
    void update() {
        entity.setName("newName");
        mongoTemplate.save(entity);
        Device foundDevice = mongoTemplate.findById(entity.getId(), Device.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }


    @Test
    void delete() {
        mongoTemplate.remove(entity);
        assertNull(mongoTemplate.findById(entity.getId(), Device.class));

    }




}
