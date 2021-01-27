package com.kang.reserve_3_1_3.rest;


import com.kang.reserve_3_1_3.models.Role;
import com.kang.reserve_3_1_3.models.User;
import com.kang.reserve_3_1_3.service.RoleService;
import com.kang.reserve_3_1_3.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final UserService userService;

    private final RoleService roleService;

    public RestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.index();
    }

    @GetMapping("/roles")
    public List<Role> showAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {

        return userService.show(id);
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.update(user.getId(), user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.delete(id);
        return "User with ID = " + id + " was deleted";
    }

}
