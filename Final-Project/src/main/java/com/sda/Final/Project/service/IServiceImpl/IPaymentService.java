package com.sda.Final.Project.service.IServiceImpl;

import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.dto.PaymentDTO;

import java.util.List;

public interface IPaymentService {

    void save(PaymentDTO paymentDTO) ;
    void update(PaymentDTO paymentDTO);
    List<PaymentDTO> findAll();
    void delete (Integer id);
}
