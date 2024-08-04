package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.PaymentDTO;
import com.sda.Final.Project.entity.PaymentEntity;
import com.sda.Final.Project.entity.UserEntity;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.mapper.PaymentMapper;
import com.sda.Final.Project.repository.PaymentRepository;
import com.sda.Final.Project.repository.UserRepository;
import com.sda.Final.Project.service.IServiceImpl.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor

public class PaymentService implements IPaymentService {
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;

    @Override
    public void save(PaymentDTO paymentDTO) {

        Optional<UserEntity> userEntities = userRepository
                .findById(paymentDTO.getIdUserPayment().getId());

        if(!userEntities.isPresent()){
            throw new NotFoundException("This user exists");
        }

        if (paymentRepository.existsById(paymentDTO.getIdUserPayment().getId())){
            throw new BadRequestException("This user has already a payment method \n Thank you for choosing us!");
        }

        paymentRepository.save(PaymentMapper.toEntity(paymentDTO,userEntities.get() ));
    }

    @Override
    public void update(PaymentDTO paymentDTO) {
        Optional<PaymentEntity> paymentEntityOptional = paymentRepository.findById(paymentDTO.getId());
        if (paymentEntityOptional.isPresent()) {
            PaymentEntity paymentEntity = paymentEntityOptional.get();

            UserEntity userEntity = userRepository.findById(paymentDTO.getIdUserPayment().getId())
                    .orElseThrow(() -> new NotFoundException("User not found"));

            PaymentMapper.toEntityForUpdate(paymentDTO, paymentEntity, userEntity);
            paymentRepository.save(paymentEntity);
        } else {
            throw new NotFoundException("Payment method cannot be found");
        }
    }


    @Override
    public List<PaymentDTO> findAll() {
        return paymentRepository.findAll().stream().map(PaymentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        paymentRepository.deleteById(id);
    }
}
