package ru.otus.shatokhin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.shatokhin.exception.UserNotFoundException;
import ru.otus.shatokhin.model.User;
import ru.otus.shatokhin.service.UserService;

import java.util.List;

@RestController
//@RequestMapping("${web.root}")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    private List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    private User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    private User findUserById(@PathVariable("id") Long userId) throws UserNotFoundException {
        return userService.findUserById(userId);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void updateUser(@PathVariable("id") Long userId, @RequestBody User user) throws UserNotFoundException {
        userService.updateUser(userId, user);
    }

}
