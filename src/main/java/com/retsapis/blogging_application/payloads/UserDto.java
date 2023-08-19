package com.retsapis.blogging_application.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username name must be min of 3 characters!")
    private String userName;

    @Email(message = "Email address is not valid!")
    @NotEmpty(message = "Email is required!")
    private String userEmail;

    @NotEmpty
    @Size(min = 6, max = 15, message = "Password must be min of 6 char and max of 15 char!")
    private String userPassword;

    @NotEmpty
    private String userAbout        ;
}
