package vn.tunguyen.jobhunter.service.mapper;

import org.springframework.stereotype.Component;

import vn.tunguyen.jobhunter.domain.User;
import vn.tunguyen.jobhunter.domain.dto.UserCreateDTO;
import vn.tunguyen.jobhunter.domain.dto.UserDTO;
import vn.tunguyen.jobhunter.domain.dto.UserUpdateDTO;

@Component
public class UserMapper {

    public User toEntity(UserCreateDTO dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .gender(dto.getGender())
                .address(dto.getAddress())
                .age(dto.getAge())
                .createdAt(dto.getCreatedAt())
                .build();
    }

    public UserCreateDTO toCreateDTO(User user) {
        return UserCreateDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender())
                .address(user.getAddress())
                .age(user.getAge())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public UserUpdateDTO toUpdateDTO(User user) {
        return UserUpdateDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .gender(user.getGender())
                .address(user.getAddress())
                .age(user.getAge())
                .updatedAt(user.getUpdatedAt())
                .build();

    }

    public UserDTO toDTO(User user) {
        return UserDTO.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .gender(user.getGender())
        .address(user.getAddress())
        .age(user.getAge())
        .updatedAt(user.getUpdatedAt())
        .createdAt(user.getCreatedAt())
        .build();
    }
}
