package test.design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Device;
import design.boilerplate.springboot.model.DeviceStatus;
import design.boilerplate.springboot.model.Room;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;


@DataMongoTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RoomRepositoryTest {

    @Autowired
    MongoTemplate mongoTemplate;



    Room entity = new Room();

    @BeforeEach
    void setUp() {
        entity.setId("123");
        entity.setNumber(123);
        entity.setFloor(null);
        entity.setDevices(null);
        mongoTemplate.save(entity);

    }
    @AfterEach
    void cleanUpDatabase() {
        mongoTemplate.remove(entity);
    }




    @Test
    void add() {
        mongoTemplate.save(entity);
        Room foundDevice = mongoTemplate.findById(entity.getId(), Room.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }

    @Test
    void getAll() {
        assertNotNull(mongoTemplate.findAll(Room.class));
        assertEquals(1, mongoTemplate.findAll(Room.class).size());

    }

    @Test
    void findById() {

        Room foundDevice = mongoTemplate.findById(entity.getId(), Room.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }

    @Test
    void update() {
        entity.setNumber(456);
        mongoTemplate.save(entity);
        Room foundDevice = mongoTemplate.findById(entity.getId(), Room.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }


    @Test
    void delete() {
        mongoTemplate.remove(entity);
        assertNull(mongoTemplate.findById(entity.getId(), Room.class));

    }

}
