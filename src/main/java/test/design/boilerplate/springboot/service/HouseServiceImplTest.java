package test.design.boilerplate.springboot.service;

import design.boilerplate.springboot.model.House;
import design.boilerplate.springboot.repository.HouseRepository;
import design.boilerplate.springboot.security.service.HouseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class HouseServiceImplTest {
    @Mock
    HouseRepository houseRepository;

    @InjectMocks
    HouseServiceImpl houseServiceImpl;

    @BeforeEach
    void setUp() {
    }

    @Test
    void GetAll() {
        List<House> result = houseServiceImpl.getAll();
        Assertions.assertEquals(Collections.<House>singletonList(new House()), result);
    }

    @Test
    void Create() {
        House result = houseServiceImpl.create(new House());
        Assertions.assertEquals(new House(), result);
    }

    @Test
    void GetOne() {
        House result = houseServiceImpl.getOne("id");
        Assertions.assertEquals(new House(), result);
    }

    @Test
    void Update() {
        House result = houseServiceImpl.update(new House());
        Assertions.assertEquals(new House(), result);
    }

    @Test
    void Delete() {
        String result = houseServiceImpl.delete("id");
        Assertions.assertEquals("house deleted", result);
    }
}

