package com.sda.Final.Project.mapper;

import com.sda.Final.Project.dto.PaymentDTO;
import com.sda.Final.Project.entity.PaymentEntity;
import com.sda.Final.Project.entity.UserEntity;

public class PaymentMapper {

    public static PaymentDTO toDTO(PaymentEntity paymentEntity) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(paymentEntity.getId());
        paymentDTO.setCreditCard(paymentEntity.getCreditCard());
        paymentDTO.setPaypal(paymentEntity.getPaypal());
        paymentDTO.setIdUserPayment(paymentEntity.getIdUserPayment());
        return paymentDTO;
    }

    public static PaymentEntity toEntity(PaymentDTO paymentDTO, UserEntity userEntity) {
        return extractFields(new PaymentEntity(), paymentDTO, userEntity);
    }

    public static PaymentEntity toEntityForUpdate(PaymentDTO paymentDTO, PaymentEntity paymentEntity, UserEntity userEntity) {
        return extractFields(paymentEntity, paymentDTO, userEntity);
    }

    private static PaymentEntity extractFields(PaymentEntity paymentEntity, PaymentDTO paymentDTO, UserEntity userEntity) {
        paymentEntity.setCreditCard(paymentDTO.getCreditCard());
        paymentEntity.setPaypal(paymentDTO.getPaypal());
        paymentEntity.setIdUserPayment(userEntity);
        return paymentEntity;
    }
}
