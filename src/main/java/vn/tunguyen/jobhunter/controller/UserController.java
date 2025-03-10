package vn.tunguyen.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.tunguyen.jobhunter.domain.User;
import vn.tunguyen.jobhunter.domain.dto.ResultPaginationDTO;
import vn.tunguyen.jobhunter.domain.dto.UserCreateDTO;
import vn.tunguyen.jobhunter.domain.dto.UserUpdateDTO;
import vn.tunguyen.jobhunter.service.UserService;
import vn.tunguyen.jobhunter.util.annotation.ApiMessage;
import vn.tunguyen.jobhunter.util.error.IdInvalidException;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turkraft.springfilter.boot.Filter;

@RequestMapping("/api/${api.version}")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserCreateDTO> createNewUser(@RequestBody User postManUser) {
        UserCreateDTO createdUser = userService.createUser(postManUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        this.userService.deleteUser(id);
        return ResponseEntity.ok("TuNguyen");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User fetchUser = this.userService.fetchUserById(id);
        return ResponseEntity.ok(fetchUser);
    }

    @GetMapping("/users")
    @ApiMessage("Get all users")
    public ResponseEntity<ResultPaginationDTO> getAllUser(
            @Filter Specification<User> spec,
            Pageable pageable) {

        return ResponseEntity.status(HttpStatus.OK).body(
                this.userService.getAllUsers(spec, pageable));
    }

    @PutMapping("/users")
    public ResponseEntity<UserUpdateDTO> updateUser(@RequestBody User user) {
        UserUpdateDTO newUser = this.userService.updateUser(user);
        return ResponseEntity.ok(newUser);
    }
}
