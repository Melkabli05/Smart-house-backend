package design.boilerplate.springboot.controller;

import design.boilerplate.springboot.model.Device;
import design.boilerplate.springboot.model.House;
import design.boilerplate.springboot.security.service.DeviceService;
import design.boilerplate.springboot.security.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/all")
    public ResponseEntity<List<House>> getAll() {
        return ResponseEntity.ok(houseService.getAll());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<House> getOne(String id) {
        return ResponseEntity.ok(houseService.getOne(id));
    }


    @PostMapping("create")
    public ResponseEntity<House> create(@Valid @RequestBody House house) {
        return ResponseEntity.ok(houseService.create(house));
    }

    // update
    @PutMapping("update")
    public ResponseEntity<House> update(@Valid @RequestBody House house) {
        return ResponseEntity.ok(houseService.update(house));
    }

    // delete
    @DeleteMapping("delete/{id}")
    public ResponseEntity<House> delete(String id) {
        return ResponseEntity.status(204).build();
    }


}
