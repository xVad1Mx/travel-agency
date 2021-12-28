package com.project.travelagency.service;

import com.project.travelagency.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    Object createUser(User user);

    Page<User> getAll(Pageable pageable);

    Optional<User> getUserById(Long id);

    User updateUser(Long id, User user) throws Throwable;

    void deleteUserById(Long id);
}
