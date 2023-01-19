package com.shop.book.model.dto.user;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserLoginDto {
    @NotBlank(message = "email is mandatory")
    @Size(min = 5, message = "email should be at least 5 symbols")
    private String email;
    @NotBlank(message = "password is mandatory")
    @Size(min = 5, message = "password should be at least 5 symbols")
    @Size(max = 30, message = "password should be at least 5 symbols")
    private String password;
}
