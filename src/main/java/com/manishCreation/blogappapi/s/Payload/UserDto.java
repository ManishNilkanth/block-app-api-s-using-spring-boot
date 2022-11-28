package com.manishCreation.blogappapi.s.Payload;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    Long userId;

    @NotEmpty
    @Size(min = 3 ,max = 20 ,message = "the name should not less than 3 letters as wel as not greater than 20 letters")
    String name;
    @Email(message = "Invalid Email format please check format")
    String email;
    @NotEmpty                                                        // both not null as wel as not empty
    @NotNull                                                        //only not null
    @Size(min = 6 ,max = 15 ,message = "the password must be greater than 6 letters as wel as less than 15 letters")
    String password;
    @NotEmpty
    @Size(min = 3,max = 200 ,message = "the about section should contains at least 3 letters or at max 200 letters")
    String about;

}
