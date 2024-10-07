package vn.tunguyen.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.tunguyen.jobhunter.domain.User;
import vn.tunguyen.jobhunter.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") long id) {
        return this.userService.fetchUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return this.userService.fetchAllUser();
    }
    @PostMapping("/users")
    public String createNewUser(@RequestBody User user) {
        this.userService.handleCreateUser(user);
        return "TuNguyen";
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return "TuNguyen";
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        User newuser = this.userService.handleUpdateUser(user);
        return newuser;
    }
}
