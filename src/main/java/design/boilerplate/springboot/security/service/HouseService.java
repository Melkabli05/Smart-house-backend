package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.House;

import java.util.List;

public interface HouseService {
    List<House> getAll();

    House create(House house);

    House getOne(String id);

    House update(House house);

    String delete(String id);
}
