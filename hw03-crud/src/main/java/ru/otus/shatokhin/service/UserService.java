package ru.otus.shatokhin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.shatokhin.exception.UserNotFoundException;
import ru.otus.shatokhin.model.User;
import ru.otus.shatokhin.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Integer userId) throws UserNotFoundException {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            return userOpt.get();
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

    public void updateUserById(Integer userId, User user) throws UserNotFoundException {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
