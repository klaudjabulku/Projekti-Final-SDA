package com.sda.Final.Project.dto;

import com.sda.Final.Project.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentDTO {

    private Integer id;
    private String creditCard;
    private String paypal;
    private UserEntity idUserPayment;
}
