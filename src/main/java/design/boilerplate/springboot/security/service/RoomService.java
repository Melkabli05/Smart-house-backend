package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAll();

    Room create(Room room);

    Room getOne(String id);

    Room update(Room room);

    String delete(String id);
}
