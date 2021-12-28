package com.project.travelagency.controller;

import com.project.travelagency.entity.Hotel;
import com.project.travelagency.entity.User;
import com.project.travelagency.service.HotelService;
import com.project.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping
    public Page<User> getAll(@PageableDefault(size = 15, sort = "id") Pageable pageable) {
        return userService.getAll(pageable);
    }

    @PostMapping
    public Object create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User user) throws Throwable {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id).stream().findFirst().orElseThrow(() -> new RuntimeException());
        return ResponseEntity.ok(user);
    }

}
