package design.boilerplate.springboot.controller;

import design.boilerplate.springboot.model.Device;
import design.boilerplate.springboot.security.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/all")
    public ResponseEntity<List<Device>> getAll() {
        return ResponseEntity.ok(deviceService.getAll());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Device> getOne(String id) {
        return ResponseEntity.ok(deviceService.getOne(id));
    }


    @PostMapping("create")
    public ResponseEntity<Device> create(@Valid @RequestBody Device device) {
        return ResponseEntity.ok(deviceService.create(device));
    }

    // update
    @PutMapping("update")
    public ResponseEntity<Device> update(@Valid @RequestBody Device device) {
        return ResponseEntity.ok(deviceService.update(device));
    }

    // delete
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Device> delete(String id) {
        return ResponseEntity.status(204).build();
    }







}
