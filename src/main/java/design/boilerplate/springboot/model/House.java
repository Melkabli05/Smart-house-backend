package design.boilerplate.springboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "houses")
public class House {

    @Id
    private String id;

    private String name;

    @Indexed(unique = true)
    private String address;

    @DBRef(lazy = true)
    private List<Floor> floors;

    @DBRef(lazy = true)
    private User owner;
}
