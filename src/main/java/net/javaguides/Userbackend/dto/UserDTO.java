package net.javaguides.Userbackend.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "Username is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Username must contain only alphanumeric characters and spaces")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be 10 digits long")
    private String contactNumber;

    @NotBlank(message = "Postal code is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "Postal code must be 6 digits long")
    private String postalCode;


}
