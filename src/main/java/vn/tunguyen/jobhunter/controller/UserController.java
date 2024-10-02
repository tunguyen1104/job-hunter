package vn.tunguyen.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.tunguyen.jobhunter.domain.User;
import vn.tunguyen.jobhunter.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String getMethodName() {
        User user = new User();
        user.setName("Tunguyen");
        user.setEmail("tunguyen@gmail.com");
        user.setPassword("123456");
        this.userService.handleCreateUser(user);
        return "TuNguyen";
    }
    
}
