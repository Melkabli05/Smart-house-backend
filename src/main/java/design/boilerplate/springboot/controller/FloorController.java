package design.boilerplate.springboot.controller;


import design.boilerplate.springboot.model.Device;
import design.boilerplate.springboot.model.Floor;
import design.boilerplate.springboot.security.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/floor")
public class FloorController {

    @Autowired
    private FloorService floorService;


    @GetMapping("/all")
    public ResponseEntity<List<Floor>> getAll() {
        return ResponseEntity.ok(floorService.getAll());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Floor> getOne(String id) {
        return ResponseEntity.ok(floorService.getOne(id));
    }

    // create
    @PostMapping("create")
    public ResponseEntity<Floor> create(@Valid @RequestBody Floor floor) {
        return ResponseEntity.ok(floorService.create(floor));
    }

    // update
    @PutMapping("update")
    public ResponseEntity<Floor> update(@Valid @RequestBody Floor floor) {
        return ResponseEntity.ok(floorService.update(floor));
    }

    // delete
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Floor> delete(String id) {
        return ResponseEntity.status(204).build();
    }


}
