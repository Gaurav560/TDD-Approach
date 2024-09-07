package com.telukso.service;

import model.User;

public interface UserService {



    User createUser(Integer id,String firstName, String lastName, String email, String password, String repeatPassword);
}
