package test.design.boilerplate.springboot.controller;

import design.boilerplate.springboot.controller.DeviceController;
import design.boilerplate.springboot.model.Device;
import design.boilerplate.springboot.model.DeviceStatus;
import design.boilerplate.springboot.security.service.DeviceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeviceController.class)
@RunWith(SpringRunner.class)
class DeviceControllerTest {

    @Autowired
    private MockMvc mockvc;

    @MockBean
    private DeviceService deviceService;


    String Url = "/api/v1/devices";
    Device entity = new Device();
    Device entity2 = new Device();

    List<Device> list = new ArrayList<>();

    @BeforeEach
    void setUp() {

        entity.setId("1");
        entity.setName("device");
        entity.setStatus(DeviceStatus.ON);
        entity.setRoom(null);

        entity2.setId("2");
        entity2.setName("device2");
        entity2.setStatus(DeviceStatus.OFF);
        entity2.setRoom(null);

        list.add(entity);

        list.add(entity);
    }



    @Test
    void GetAll() throws Exception {
        when(deviceService.getAll()).thenReturn(list);
        mockvc.perform(get(Url+"/all")).andExpect(status().isOk());
    }


    @Test
    void GetOne() throws Exception {
        when(deviceService.getOne(entity.getId())).thenReturn(entity);
        mockvc.perform(get(Url+"/get/"+entity.getId())).andExpect(status().isOk());

    }

    @Test
    void Create() throws Exception {
        when(deviceService.create(entity)).thenReturn(entity);
        mockvc.perform(post(Url+"/create").content(entity.toString())).andExpect(status().isOk());


    }

    @Test
    void Update() throws Exception {
        when(deviceService.update(entity)).thenReturn(entity);
        mockvc.perform(put(Url+"/update").content(entity.toString())).andExpect(status().isOk());


    }

    @Test
    void Delete() throws Exception {
        doNothing().when(deviceService).delete("1");
        mockvc.perform(delete(Url+"/delete/"+entity.getId())).andExpect(status().isOk());

    }
}

