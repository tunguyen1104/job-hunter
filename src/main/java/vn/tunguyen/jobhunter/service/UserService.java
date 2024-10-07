package vn.tunguyen.jobhunter.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import vn.tunguyen.jobhunter.domain.User;
import vn.tunguyen.jobhunter.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User fetchUserById(long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }
    public List<User> fetchAllUser() {
        return this.userRepository.findAll();
    }
    public User handleUpdateUser(User reqUser) {
        User currentUser = this.fetchUserById(reqUser.getId());
        if (currentUser != null) {
            currentUser.setEmail(reqUser.getEmail());
            currentUser.setName(reqUser.getName());
            currentUser.setPassword(reqUser.getPassword());

            currentUser = this.userRepository.save(currentUser);
        }
        return currentUser;
    }
    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }
    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }
}
