package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Floor;
import design.boilerplate.springboot.repository.FloorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorRepository floorRepository;

    @Override
    public List<Floor> getAll() {
        try {
            log.info("get all floors");
            return floorRepository.findAll();
        } catch (Exception e) {
            log.error("error getting all floors", e);
            return null;
        }
    }

    @Override
    public Floor create(Floor floor) {
        try {
            log.info("create floor {}", floor);
            return floorRepository.save(floor);
        } catch (Exception e) {
            log.error("error creating floor {}", floor);
            return null;
        }
    }

    @Override
    public Floor getOne(String id) {
        try {
           log.info("get floor {}", id);
           return floorRepository.findById(id).get();
        } catch (Exception e) {
            log.error("error getting floor {}", id , e);
            return null;
        }

    }

    @Override
    public Floor update(Floor floor) {
        try {
            log.info("update floor {}", floor);
            return floorRepository.save(floor);
        } catch (Exception e) {
            log.error("error updating floor {}", floor, e);
            return null;
        }
    }

    @Override
    public String delete(String id) {
        try {
            log.info("delete floor {}", id);
            floorRepository.deleteById(id);
            return "floor deleted";
        } catch (Exception e) {
            log.error("error deleting floor {}", id, e);
            return "error deleting floor";
        }
    }
}
