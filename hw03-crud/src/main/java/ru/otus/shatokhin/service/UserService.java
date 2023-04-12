package ru.otus.shatokhin.service;

import ru.otus.shatokhin.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(Long id);

    User createUser(User User);

    User updateUser(Long userId, User user);

    void deleteUserById(Long id);
}
