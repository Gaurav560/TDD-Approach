package com.telukso.service;

import model.User;

public class UserServiceImpl implements UserService {


    @Override
    public User createUser(Integer id, String firstName, String lastName, String email, String password, String repeatPassword) {
        if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name should not be empty");
        }

        return new User(id, firstName, lastName, email);
    }
}
