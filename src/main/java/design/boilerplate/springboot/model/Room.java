package design.boilerplate.springboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "rooms")
public class Room {

    @Id
    private String id;

    private int number;

    @DBRef(lazy = true)
    private Floor floor;

    @DBRef(lazy = true)
    private List<Device> devices;



}
