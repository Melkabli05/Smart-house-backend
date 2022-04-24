package design.boilerplate.springboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "floors")
public class Floor {
    @Id
    private String id;

    private String number;

    @DBRef(lazy = true)
    private List<Room> rooms;

    @DBRef(lazy = true)
    private House house;

}
