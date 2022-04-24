package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Device;

import java.util.List;

public interface DeviceService {

    List<Device> getAll();

    Device create(Device device);

    Device getOne(String id);

    Device update(Device device);

    String delete(String id);

}
