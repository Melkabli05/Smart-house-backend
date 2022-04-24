package design.boilerplate.springboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
@ToString
public class User {

	@Id
	private String id;

	private String name;

	private String username;

	private String password;

	private String email;

	private UserRole userRole;



}
