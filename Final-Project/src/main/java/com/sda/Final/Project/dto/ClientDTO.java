package com.sda.Final.Project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClientDTO{
    private Integer id;

    @NotNull(message = "The name can't be null")
    @NotBlank(message = "The name can't be blank")
    @NotEmpty(message = "The name can't be empty")
    @Pattern(regexp = "^[A-Za-z]+ [A-Za-z]+$",
            message = "Please insert your name")

    private String name;

    @NotNull(message = "The surname can't be null")
    @NotBlank(message = "The surname can't be blank")
    @NotEmpty(message = "The surname can't be empty")
    @Pattern(regexp = "^[A-Za-z]+ [A-Za-z]+$",
            message = "Please insert your surname")
    private String surname;

    private String phone;

    @NotNull(message = "The email can't be null")
    @NotBlank(message = "The email can't be blank")
    @NotEmpty(message = "The email can't be empty")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "Please insert your Email")
    private String email;

    public ClientDTO(Integer id) {
        this.id = id;
    }
}
