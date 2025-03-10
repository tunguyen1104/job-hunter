package vn.tunguyen.jobhunter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

import vn.tunguyen.jobhunter.domain.User;
import vn.tunguyen.jobhunter.domain.dto.Meta;
import vn.tunguyen.jobhunter.domain.dto.ResultPaginationDTO;
import vn.tunguyen.jobhunter.domain.dto.UserCreateDTO;
import vn.tunguyen.jobhunter.domain.dto.UserUpdateDTO;
import vn.tunguyen.jobhunter.repository.UserRepository;
import vn.tunguyen.jobhunter.service.mapper.UserMapper;
import vn.tunguyen.jobhunter.util.error.IdInvalidException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User fetchUserById(long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public ResultPaginationDTO getAllUsers(Specification<User> spec, Pageable pageable) {
        Page<User> pageUser = this.userRepository.findAll(spec, pageable);
        ResultPaginationDTO rs = new ResultPaginationDTO();
        Meta mt = new Meta();

        mt.setPage(pageable.getPageNumber() + 1);
        mt.setPageSize(pageable.getPageSize());

        mt.setPages(pageUser.getTotalPages());
        mt.setTotal(pageUser.getTotalElements());

        rs.setMeta(mt);
        rs.setResult(pageUser.getContent());

        return rs;
    }

    public UserUpdateDTO updateUser(User reqUser) {
        User existingUser = userRepository.findById(reqUser.getId())
                .orElseThrow(() -> new IdInvalidException("User not found with ID: " + reqUser.getId()));

        existingUser.setAddress(reqUser.getAddress());
        existingUser.setGender(reqUser.getGender());
        existingUser.setAge(reqUser.getAge());
        existingUser.setName(reqUser.getName());

        User savedUser = userRepository.save(existingUser);
        return userMapper.toUpdateDTO(savedUser);
    }

    public UserCreateDTO createUser(User user) {
        this.validateEmailUniqueness(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = this.userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public void validateEmailUniqueness(String email){
        if (this.userRepository.existsByEmail(email)) {
            throw new IdInvalidException("Email " + email + " already exists, please use another email.");
        }
    }

    public boolean isEmailExist(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return this.userRepository.findByEmail(username);
    }
}
