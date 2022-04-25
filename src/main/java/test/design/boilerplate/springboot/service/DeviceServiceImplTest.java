package test.design.boilerplate.springboot.service;

import design.boilerplate.springboot.model.Device;
import design.boilerplate.springboot.repository.DeviceRepository;
import design.boilerplate.springboot.security.service.DeviceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import java.util.Collections;
import java.util.List;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class DeviceServiceImplTest {
    @Mock
    DeviceRepository deviceRepository;
    @Mock
    Logger log;
    @InjectMocks
    DeviceServiceImpl deviceServiceImpl;


    @BeforeEach
    void setUp() {
    }

    @Test
    void GetAll() {
        List<Device> result = deviceServiceImpl.getAll();
        Assertions.assertEquals(Collections.<Device>singletonList(new Device()), result);
    }

    @Test
    void Create() {
        Device result = deviceServiceImpl.create(new Device());
        Assertions.assertEquals(new Device(), result);
    }

    @Test
    void GetOne() {
        Device result = deviceServiceImpl.getOne("id");
        Assertions.assertEquals(new Device(), result);
    }

    @Test
    void Update() {
        Device result = deviceServiceImpl.update(new Device());
        Assertions.assertEquals(new Device(), result);
    }

    @Test
    void Delete() {
        String result = deviceServiceImpl.delete("id");
        Assertions.assertEquals("device deleted", result);
    }
}

