package ru.otus.shatokhin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.shatokhin.exception.UserNotFoundException;
import ru.otus.shatokhin.model.User;
import ru.otus.shatokhin.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    private User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user/{userId}")
    private User getUserById(@PathVariable Integer userId) throws UserNotFoundException {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/user/{userId}")
    private void deleteUserById(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
    }

    @PutMapping("/user/{userId}")
    private void updateUser(@PathVariable Integer userId, @RequestBody User user) throws UserNotFoundException {
        userService.updateUserById(userId, user);
    }

}
