package com.anup.ecommerce.service;

import com.anup.ecommerce.constant.EmailTemplate;
import com.anup.ecommerce.dto.Product;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    // TODO: Create a generic method to send email

    @Async
    public void sendPaymentSuccessEmail(String customerEmail, String customerName, BigDecimal amount, String orderReference) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_RELATED, UTF_8.name());

        final String emailTemplate = EmailTemplate.PAYMENT_CONFIRMATION.getTemplate();

        Map<String, Object> templateModel = Map.of(
                "customerName", customerName,
                "amount", amount,
                "orderReference", orderReference
        );

        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);

        messageHelper.setTo(customerEmail);
        messageHelper.setFrom("anup.gupta@nonstopio.com");
        messageHelper.setSubject(EmailTemplate.PAYMENT_CONFIRMATION.getSubject());

        try {
            String htmlBody = templateEngine.process(emailTemplate, thymeleafContext);
            messageHelper.setText(htmlBody, true);

            javaMailSender.send(message);
            log.info("Email sent to {} with subject {} and template {}", customerEmail, EmailTemplate.PAYMENT_CONFIRMATION.getSubject(), emailTemplate);
        } catch (MessagingException e) {
            log.warn("Failed to send email to {} with subject {} and template {}", customerEmail, EmailTemplate.PAYMENT_CONFIRMATION.getSubject(), emailTemplate);
        }
    }

    @Async
    public void sendOrderSuccessEmail(String customerEmail, String customerName, BigDecimal totalAmount, String orderReference, List<Product> products) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_RELATED, UTF_8.name());

        final String emailTemplate = EmailTemplate.ORDER_CONFIRMATION.getTemplate();

        Map<String, Object> templateModel = Map.of(
                "customerName", customerName,
                "totalAmount", totalAmount,
                "orderReference", orderReference,
                "products", products
        );

        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);

        messageHelper.setTo(customerEmail);
        messageHelper.setFrom("anup.gupta@nonstopio.com");
        messageHelper.setSubject(EmailTemplate.ORDER_CONFIRMATION.getSubject());

        try {
            String htmlBody = templateEngine.process(emailTemplate, thymeleafContext);
            messageHelper.setText(htmlBody, true);

            javaMailSender.send(message);
            log.info("Email sent to {} with subject {} and template {}", customerEmail, EmailTemplate.ORDER_CONFIRMATION.getSubject(), emailTemplate);
        } catch (MessagingException e) {
            log.warn("Failed to send email to {} with subject {} and template {}", customerEmail, EmailTemplate.ORDER_CONFIRMATION.getSubject(), emailTemplate);
        }
    }
}
