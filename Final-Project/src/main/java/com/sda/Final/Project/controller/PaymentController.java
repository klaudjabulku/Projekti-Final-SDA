package com.sda.Final.Project.controller;

import com.sda.Final.Project.dto.PaymentDTO;
import com.sda.Final.Project.service.IServiceImpl.IPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {


    private IPaymentService iPaymentService;

    @PostMapping
    public void save(@RequestBody PaymentDTO paymentDTO){
        iPaymentService.save(paymentDTO);
    }

    @PutMapping
    public void update(@RequestBody PaymentDTO paymentDTO){
        iPaymentService.update(paymentDTO);
    }

    @GetMapping
    public List<PaymentDTO> findAll(){
        return iPaymentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        iPaymentService.delete(id);
    }
}
