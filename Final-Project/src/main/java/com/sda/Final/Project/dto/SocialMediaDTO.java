package com.sda.Final.Project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SocialMediaDTO {

    private Integer id;

    @NotNull(message = "Linkedin can´t be null")
    @NotBlank(message = "Linkedin can´t be blank")
    @NotEmpty(message = "Linkedin can´t be empty")
    private String linkedin;


    @NotNull(message = "Instagram can´t be null")
    @NotBlank(message = "Instagram can´t be blank")
    @NotEmpty(message = "Instagram can´t be empty")

    private String instagram;


    @NotNull(message = "Facebook can´t be null")
    @NotBlank(message = "Facebook can´t be blank")
    @NotEmpty(message = "Facebook can´t be empty")
    private String facebook;

    private UserDTO userDTO;

}


