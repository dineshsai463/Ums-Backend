package net.javaguides.Userbackend.service.impl;

import net.javaguides.Userbackend.dto.UserDTO;
import net.javaguides.Userbackend.entity.User;
import net.javaguides.Userbackend.mapper.UserMapper;

import net.javaguides.Userbackend.repository.UserRepository;
import net.javaguides.Userbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = UserMapper.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(savedUser);
    }


    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.mapToUserDTO(user);
    }


    @Override
    public UserDTO updateUserById(Long id, UserDTO updatedUserDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        User updatedUser = UserMapper.mapToUser(updatedUserDTO);
        updatedUser.setId(existingUser.getId());
        User savedUser = userRepository.save(updatedUser);
        return UserMapper.mapToUserDTO(savedUser);
    }
}