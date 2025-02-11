package com.anup.ecommerce.mapper;

import com.anup.ecommerce.constant.NotificationType;
import com.anup.ecommerce.dto.OrderConfirmation;
import com.anup.ecommerce.dto.PaymentConfirmation;
import com.anup.ecommerce.entity.Notification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class NotificationMapper {
    public static Notification toEntity(NotificationType notificationType, PaymentConfirmation paymentConfirmation) {
        return Notification.builder()
                .type(notificationType)
                .paymentConfirmation(paymentConfirmation)
                .build();

    }

    public static Notification toEntity(NotificationType notificationType, OrderConfirmation orderConfirmation) {
        return Notification.builder()
                .type(notificationType)
                .orderConfirmation(orderConfirmation)
                .build();
    }
}
