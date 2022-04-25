package test.design.boilerplate.springboot.service;

import design.boilerplate.springboot.model.Floor;
import design.boilerplate.springboot.repository.FloorRepository;
import design.boilerplate.springboot.security.service.FloorServiceImpl;
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
class FloorServiceImplTest {
    @Mock
    FloorRepository floorRepository;

    @InjectMocks
    FloorServiceImpl floorServiceImpl;

    @BeforeEach
    void setUp() {
    }

    @Test
    void GetAll() {
        List<Floor> result = floorServiceImpl.getAll();
        Assertions.assertEquals(Collections.<Floor>singletonList(new Floor()), result);
    }

    @Test
    void Create() {
        Floor result = floorServiceImpl.create(new Floor());
        Assertions.assertEquals(new Floor(), result);
    }

    @Test
    void GetOne() {
        Floor result = floorServiceImpl.getOne("id");
        Assertions.assertEquals(new Floor(), result);
    }

    @Test
    void Update() {
        Floor result = floorServiceImpl.update(new Floor());
        Assertions.assertEquals(new Floor(), result);
    }

    @Test
    void Delete() {
        String result = floorServiceImpl.delete("id");
        Assertions.assertEquals("floor deleted", result);
    }
}

