package design.boilerplate.springboot.controller;

import design.boilerplate.springboot.model.Device;
import design.boilerplate.springboot.model.Room;
import design.boilerplate.springboot.security.service.DeviceService;
import design.boilerplate.springboot.security.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAll() {
        return ResponseEntity.ok(roomService.getAll());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Room> getOne(String id) {
        return ResponseEntity.ok(roomService.getOne(id));
    }


    @PostMapping("create")
    public ResponseEntity<Room> create(@Valid @RequestBody Room room) {
        return ResponseEntity.ok(roomService.create(room));
    }

    // update
    @PutMapping("update")
    public ResponseEntity<Room> update(@Valid @RequestBody Room room) {
        return ResponseEntity.ok(roomService.update(room));
    }

    // delete
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Room> delete(String id) {
        return ResponseEntity.status(204).build();
    }




}
