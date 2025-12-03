package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.UserDTO;
import com.doki.dentalapp.mapper.UserMapper;
import com.doki.dentalapp.model.User;
import com.doki.dentalapp.repository.ClinicRepository;
import com.doki.dentalapp.repository.UserRepository;
import com.doki.dentalapp.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ClinicRepository clinicRepository;

    @Override
    public User createUser(String username, String rawPassword, String roleName) {
        User user = new User();
        user.setUsername(username);
        // user.setPassword(passwordEncoder.encode(rawPassword)); // hash password
        user.setPassword(rawPassword); // hash password

        // assign roles
        user.setRole(Role.valueOf(roleName));

        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    @Override
    public UserDTO getById(UUID id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserDTO create(UserDTO dto) {
        User user = UserMapper.toEntity(dto);

        return UserMapper.toDTO(userRepository.save(user));
    }
    @Override
    public UserDTO update(UUID id, UserDTO dto) {

        //TODO: Update user password and fullName. The username shall remain as it is.

        return UserMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findByUsername(String username) {
        System.out.println("✅ findByUsername running..."+ username);

        return userRepository.findByUsername(username)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
