package net.javaguides.Userbackend.mapper;

import net.javaguides.Userbackend.dto.UserDTO;
import net.javaguides.Userbackend.entity.User;
import org.mapstruct.Mapper;


@Mapper
public class UserMapper {

    public static UserDTO mapToUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getContactNumber(),
                user.getPostalCode()
        );
    }

    public static User mapToUser(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getContactNumber(),
                userDTO.getPostalCode()
        );
    }
}