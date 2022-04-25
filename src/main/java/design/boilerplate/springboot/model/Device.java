package design.boilerplate.springboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "devices")

public class Device {

    @Id
    private String id;

    private String name;

    @DBRef(lazy = true)
    private Room room;



    private DeviceStatus status;


}
