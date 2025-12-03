package com.doki.dentalapp.mapper;


import com.doki.dentalapp.dto.UserDTO;
import com.doki.dentalapp.model.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFullName(),
                user.getClinicId(),
                user.getRole(),
                user.getEmail()

        );
    }

    public static User toEntity(UserDTO dto) {
        return User.builder()
                .id(dto.id())
                .username(dto.username())
                .password(dto.password())
                .fullName(dto.fullName())
                .clinicId(dto.clinicId())
                .role(dto.role())
                .email(dto.email())
                .build();
    }
}
