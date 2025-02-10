package com.anup.ecommerce.service;

import com.anup.ecommerce.dto.request.PaymentCreateRequest;
import com.anup.ecommerce.entity.Payment;
import com.anup.ecommerce.mapper.NotificationMapper;
import com.anup.ecommerce.mapper.PaymentMapper;
import com.anup.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final NotificationProducerService notificationProducerService;

    public Long createPayment(PaymentCreateRequest request) {
        Payment payment = paymentRepository.save(PaymentMapper.toEntity(request));

        notificationProducerService.sendNotification(NotificationMapper.toRequest(request));

        return payment.getId();
    }
}
