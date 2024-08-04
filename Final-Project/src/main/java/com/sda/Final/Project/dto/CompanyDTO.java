package com.sda.Final.Project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    private Integer id;

    @NotNull(message = "The name of the company can't be null")
    @NotBlank(message = "The name of the company can't be blank")
    @NotEmpty(message = "The name of the company can't be empty")
    private String companyName;

    private UserDTO idUserCompany;

}
