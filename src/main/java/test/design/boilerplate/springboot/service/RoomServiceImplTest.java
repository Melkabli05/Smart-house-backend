package test.design.boilerplate.springboot.service;

import design.boilerplate.springboot.model.Room;
import design.boilerplate.springboot.repository.RoomRepository;
import design.boilerplate.springboot.security.service.RoomServiceImpl;
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
class RoomServiceImplTest {
    @Mock
    RoomRepository roomRepository;

    @InjectMocks
    RoomServiceImpl roomServiceImpl;

    @BeforeEach
    void setUp() {
    }

    @Test
    void GetAll() {
        List<Room> result = roomServiceImpl.getAll();
        Assertions.assertEquals(Collections.<Room>singletonList(new Room()), result);
    }

    @Test
    void Create() {
        Room result = roomServiceImpl.create(new Room());
        Assertions.assertEquals(new Room(), result);
    }

    @Test
    void GetOne() {
        Room result = roomServiceImpl.getOne("id");
        Assertions.assertEquals(new Room(), result);
    }

    @Test
    void testUpdate() {
        Room result = roomServiceImpl.update(new Room());
        Assertions.assertEquals(new Room(), result);
    }

    @Test
    void testDelete() {
        String result = roomServiceImpl.delete("id");
        Assertions.assertEquals("room deleted", result);
    }
}

