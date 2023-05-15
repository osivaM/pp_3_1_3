package com.github.osivaM.pp_3_1_3.services;

import com.github.osivaM.pp_3_1_3.models.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    User getUserByName(String name);

    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

}
