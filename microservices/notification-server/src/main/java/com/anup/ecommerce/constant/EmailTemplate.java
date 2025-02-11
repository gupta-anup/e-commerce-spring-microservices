package com.anup.ecommerce.constant;

public enum EmailTemplate {
    PAYMENT_CONFIRMATION("email/payment-confirmation", "Payment Confirmation"),
    ORDER_CONFIRMATION("email/order-confirmation", "Order Confirmation");

    private final String template;
    private final String subject;

    EmailTemplate(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }

    public String getTemplate() {
        return template;
    }

    public String getSubject() {
        return subject;
    }
}
