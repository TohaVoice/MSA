package ru.otus.shatokhin.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.shatokhin.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
