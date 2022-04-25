package test.design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.House;
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
class HouseRepositoryTest {


    @Autowired
    MongoTemplate mongoTemplate;


    House entity = new House();

    @BeforeEach
    void setUp() {
        entity.setId("123");
        entity.setName("device");
        entity.setAddress("address");
        entity.setFloors(null);
        entity.setOwner(null);
        mongoTemplate.save(entity);

    }
    @AfterEach
    void cleanUpDatabase() {
        mongoTemplate.remove(entity);
    }








    @Test
    void add() {
        mongoTemplate.save(entity);
        House foundDevice = mongoTemplate.findById(entity.getId(), House.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }

    @Test
    void getAll() {
        assertNotNull(mongoTemplate.findAll(House.class));
        assertEquals(1, mongoTemplate.findAll(House.class).size());

    }

    @Test
    void findById() {

        House foundDevice = mongoTemplate.findById(entity.getId(), House.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }

    @Test
    void update() {
        entity.setName("newName");
        mongoTemplate.save(entity);
        House foundDevice = mongoTemplate.findById(entity.getId(), House.class);
        assert foundDevice != null;
        assertEquals(entity, foundDevice);
        mongoTemplate.remove(foundDevice);

    }


    @Test
    void delete() {
        mongoTemplate.remove(entity);
        assertNull(mongoTemplate.findById(entity.getId(), House.class));

    }

}
