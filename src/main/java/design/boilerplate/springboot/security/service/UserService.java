package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.RegistrationResponse;

import java.util.List;


public interface UserService {

	List<User> getAll();

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
