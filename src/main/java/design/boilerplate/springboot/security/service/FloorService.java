package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Floor;

import java.util.List;

public interface FloorService {
    List<Floor> getAll();

    Floor create(Floor floor);

    Floor getOne(String id);

    Floor update(Floor floor);

    String delete(String id);
}
