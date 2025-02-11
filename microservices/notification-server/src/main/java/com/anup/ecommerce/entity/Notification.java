package com.anup.ecommerce.entity;

import com.anup.ecommerce.constant.NotificationType;
import com.anup.ecommerce.dto.OrderConfirmation;
import com.anup.ecommerce.dto.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Notification {

    @Id
    private String id;
    private NotificationType type;

    @CreatedDate
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
