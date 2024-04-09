package net.javaguides.Userbackend.service;


import net.javaguides.Userbackend.dto.UserDTO;
import net.javaguides.Userbackend.entity.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO addUser(UserDTO userDTO);
    void deleteUserById(Long id);
    UserDTO getUserById(Long id);
    UserDTO updateUserById(Long id, UserDTO updatedUserDTO);
}
