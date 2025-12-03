package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.UserDTO;
import com.doki.dentalapp.model.User;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService {
    public List<UserDTO> getAll();
    public UserDTO getById(UUID id);
    public UserDTO create(UserDTO dto);
    public UserDTO update(UUID id, UserDTO dto);
    public void delete(UUID id);

    public UserDTO findByUsername(String username);
    public User createUser(String username, String rawPassword, String roleName);
}
