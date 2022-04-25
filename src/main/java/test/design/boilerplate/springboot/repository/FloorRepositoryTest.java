package test.design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Device;
import design.boilerplate.springboot.model.DeviceStatus;
import design.boilerplate.springboot.model.Floor;
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
class FloorRepositoryTest {

    @Autowired
    MongoTemplate mongoTemplate;

    Floor entity = new Floor();


    @BeforeEach
    void setUp() {
        entity.setId("123");
        entity.setNumber(null);
        entity.setRooms(null);
        entity.setHouse(null);
        mongoTemplate.save(entity);

    }
    @AfterEach
    void cleanUpDatabase() {
        mongoTemplate.remove(entity);
    }





    @Test
    void add() {
        mongoTemplate.save(entity);
        Floor foundDevice = mongoTemplate.findById(entity.getId(), Floor.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }

    @Test
    void getAll() {
        assertNotNull(mongoTemplate.findAll(Floor.class));
        assertEquals(1, mongoTemplate.findAll(Floor.class).size());

    }

    @Test
    void findById() {

        Floor foundDevice = mongoTemplate.findById(entity.getId(), Floor.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }

    @Test
    void update() {
        entity.setNumber("1");
        mongoTemplate.save(entity);
        Floor foundDevice = mongoTemplate.findById(entity.getId(), Floor.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }


    @Test
    void delete() {
        mongoTemplate.remove(entity);
        assertNull(mongoTemplate.findById(entity.getId(), Floor.class));

    }
}
