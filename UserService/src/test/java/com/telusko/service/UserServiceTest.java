package com.telusko.service;

import com.telukso.service.UserService;
import com.telukso.service.UserServiceImpl;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {

    UserService userService;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;
    Integer id;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
        id = 3;
        firstName = "John";
        lastName = "Doe";
        email = "gsharma1154@gmail.com";
        password = "password";
        repeatPassword = "password";
    }


    @Test
    @DisplayName("Test create user")
    void testCreateUser_whenUserDetailsProvided_returnUserObject() {
        //Act
        User user = userService.createUser(id, firstName, lastName, email, password, repeatPassword);

        //Assert
        assertNotNull(user, "User object should not be null");
        assertEquals(firstName, user.getFirstName(), "First name should be same as provided");
        assertEquals(lastName, user.getLastName(), "Last name should be same as provided");
        assertEquals(email, user.getEmail(), "Email should be same as provided");
        assertNotNull(user.getId(), "Id should not be null");

    }


    @Test
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        firstName = "";
        //Act && Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    User user = userService.createUser(id, firstName, lastName, email, password, repeatPassword);
                },
                "First name should not be empty");

        assertEquals("First name should not be empty", thrown.getMessage(), "Exception error message is not correct");

    }


    @Test
    void testCreateUser_whenLastNameIsEmpty_throwsIllegalArgumentException(){

        lastName = "";
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            userService.createUser(id, firstName, lastName, email, password, repeatPassword);
                },
                "Last name should not be empty");
    }

}
