package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.House;
import design.boilerplate.springboot.repository.HouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j @Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;


    @Override
    public List<House> getAll() {
        try {
            log.info("get all houses");
            return houseRepository.findAll();
        }   catch (Exception e) {
            log.error("error getting all houses {}", e.getMessage());
            return null;
        }

    }

    @Override
    public House create(House house) {
        try {
            log.info("create house");
            return houseRepository.save(house);
        } catch (Exception e) {
            log.error("error creating house {}", e.getMessage());
            return null;
        }

    }

    @Override
    public House getOne(String id) {
        try {
            log.info("get house by id");
            return houseRepository.findById(id).orElseThrow(() -> new RuntimeException("House not found"));
        } catch (Exception e) {
            log.error("error getting house by id {}", e.getMessage());
            return null;
        }
    }

    @Override
    public House update(House house) {
        try {
            log.info("update house");
            return houseRepository.save(house);
        } catch (Exception e) {
            log.error("error updating house {}", e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(String id) {
        try {
            log.info("delete house");
            houseRepository.deleteById(id);
            return "House deleted";
        } catch (Exception e) {
            log.error("error deleting house {}", e.getMessage());
            return null;
        }
    }
}
