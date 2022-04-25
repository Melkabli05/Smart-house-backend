package test.design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.DeviceStatus;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.model.UserRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@DataMongoTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UserRepositoryTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private User user = new User();


    @BeforeEach
    void setUp() {
        user.setId("abc");
        user.setName("test");
        user.setUsername("user");
        user.setEmail("test@gmail.com");
        user.setPassword("password");
        user.setUserRole(UserRole.USER);

        mongoTemplate.save(user);
    }


    @AfterEach
    void tearDown() {

        mongoTemplate.remove(user);
    }

    @Test
    void findByUsername() {
        User user = mongoTemplate.findOne(query(where("username").is("user")), User.class);
        assertNotNull(user);
        assertEquals("user", user.getUsername());
    }

    @Test
    void existsByEmail() {
        User user = mongoTemplate.findOne(query(where("email").is("test@gmail.com")), User.class);
        assertNotNull(user);
        assertEquals("user", user.getUsername());

    }

    @Test
    void existsByUsername() {
        User user = mongoTemplate.findOne(query(where("username").is("user")), User.class);
        assertNotNull(user);
        assertEquals("user", user.getUsername());
    }
}


