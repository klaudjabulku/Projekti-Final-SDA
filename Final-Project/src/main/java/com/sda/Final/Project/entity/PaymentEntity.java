package com.sda.Final.Project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "credit_card")
    private String creditCard;

    @Column(name = "paypal")
    private String paypal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_payment",referencedColumnName = "id")
    private UserEntity idUserPayment;

}
