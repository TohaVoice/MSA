package ru.otus.shatokhin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.shatokhin.exception.UserNotFoundException;
import ru.otus.shatokhin.model.User;
import ru.otus.shatokhin.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User user) throws UserNotFoundException {
        if (userRepository.findById(userId).isPresent()) {
            user.setId(userId);
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
