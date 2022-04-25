package test.design.boilerplate.springboot.service;

import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.model.UserRole;
import design.boilerplate.springboot.repository.UserRepository;
import design.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.RegistrationResponse;
import design.boilerplate.springboot.security.service.UserServiceImpl;
import design.boilerplate.springboot.service.UserValidationService;
import design.boilerplate.springboot.utils.GeneralMessageAccessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;
    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    UserValidationService userValidationService;
    @Mock
    GeneralMessageAccessor generalMessageAccessor;
    @Mock
    Logger log;
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {
        List<User> result = userServiceImpl.getAll();
        Assertions.assertEquals(Collections.<User>singletonList(new User("id", "name", "username", "password", "email", UserRole.USER)), result);
    }

    @Test
    void testFindByUsername() {
        when(userRepository.findByUsername(anyString())).thenReturn(new User("id", "name", "username", "password", "email", UserRole.USER));

        User result = userServiceImpl.findByUsername("username");
        Assertions.assertEquals(new User("id", "name", "username", "password", "email", UserRole.USER), result);
    }

    @Test
    void testRegistration() {
        when(generalMessageAccessor.getMessage(any(), anyString(), anyVararg())).thenReturn("getMessageResponse");

        RegistrationResponse result = userServiceImpl.registration(new RegistrationRequest());
        Assertions.assertEquals(new RegistrationResponse("message"), result);
    }

    @Test
    void testFindAuthenticatedUserByUsername() {
        when(userRepository.findByUsername(anyString())).thenReturn(new User("id", "name", "username", "password", "email", UserRole.USER));

        AuthenticatedUserDto result = userServiceImpl.findAuthenticatedUserByUsername("username");
        Assertions.assertEquals(new AuthenticatedUserDto(), result);
    }
}

