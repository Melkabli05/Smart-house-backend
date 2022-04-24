package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Device;
import design.boilerplate.springboot.model.Floor;
import design.boilerplate.springboot.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> getAll() {
        try {
            log.info("get all devices");
            return deviceRepository.findAll();
        } catch (Exception e) {
            log.error("error getting all devices {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Device create(Device device) {
        try {
            log.info("create device {}", device.getId());
            deviceRepository.save(device);
            return device;
        } catch (Exception e) {
            log.error("error creating device {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Device getOne(String id) {
        try {
            log.info("get device {}", id);
            return deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
        } catch (Exception e) {
            log.error("error getting device {}", e.getMessage());
            return null;
        }

    }

    @Override
    public Device update(Device device) {
        try {
            log.info("update device {}", device.getId());
            deviceRepository.save(device);
            return device;
        } catch (Exception e) {
            log.error("error updating device {}", e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(String id) {
        try {
            log.info("delete device {}", id);
            deviceRepository.deleteById(id);
            return "Device deleted";
        } catch (Exception e) {
            log.error("error deleting device {}", e.getMessage());
            return "Error deleting device";
        }
    }
}
