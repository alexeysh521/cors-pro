package com.example.cors_test.service;

import com.example.cors_test.dto.TildaFormRequest;
import com.example.cors_test.persistence.model.FormSubmission;
import com.example.cors_test.persistence.repository.FormSubmissionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class FormProcessingService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final FormSubmissionRepository repository;
    private final JavaMailSender mailSender;
    private final ObjectMapper objectMapper;


    public ResponseEntity<Map<String, String>> handleTrainingRequest(Map<String, String> params, String pageUrl) {
        // логика сохранения заявки на тренировку
        LOGGER.info("Handling training request url={} and form={}", pageUrl, params);
        return ResponseEntity.ok(Map.of("status", "success", "message", "Заявка на тренировку сохранена"));
    }

    public ResponseEntity<Map<String, String>> handleContactRequest(Map<String, String> params, String pageUrl) {
        // логика обратной связи
        return ResponseEntity.ok(Map.of("status", "success", "message", "Сообщение получено"));
    }

    public ResponseEntity<Map<String, String>> handleFoodOrder(Map<String, String> params, String pageUrl) {
        // логика обработки заказа
        return ResponseEntity.ok(Map.of("status", "success", "message", "Заказ принят в обработку"));
    }

//    @Value("${tilda.notification.admin-email}")
//    private String adminEmail;
//
//    @Value("${tilda.notification.send-email}")
//    private boolean sendEmail;
//
//    public void processForm(TildaFormRequest request, String pageUrl) {
//        try {
//
//            FormSubmission submission = new FormSubmission();
//            submission.setFormName("training");
//            submission.setName(request.getName());
//            submission.setEmail(request.getEmail());
//            submission.setMessage(request.getMessage());
//            submission.setPageUrl(pageUrl); //
//            submission.setFormData(objectMapper.writeValueAsString(request.getAllFields()));
//
//            repository.save(submission);
//            LOGGER.info("Form saved from: {}", pageUrl);
//
//            if (sendEmail) {
//                sendEmailNotification(request, pageUrl);
//            }
//
//            // if (sendTelegram) { ... }
//
//        } catch (Exception e) {
//            LOGGER.error("Error processing form from: {}", pageUrl, e);
//            throw new RuntimeException("Form processing failed", e);
//        }
//    }
//
//    private void sendEmailNotification(TildaFormRequest request, String pageUrl) {
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(adminEmail);
//            message.setSubject("🏋️ Новая заявка на тренировку");
//            message.setText(createEmailText(request, pageUrl));
//
//            mailSender.send(message);
//            LOGGER.info("Email notification sent to: {}", adminEmail);
//        } catch (Exception e) {
//            LOGGER.error("Failed to send email notification", e);
//        }
//    }
//
//    private String createEmailText(TildaFormRequest request, String pageUrl) {
//        return String.format("""
//        🏋️ Новая заявка на тренировку
//        --------------------
//        📝 Имя: %s
//        📧 Email: %s
//        💬 Комментарий: %s
//        🌐 Страница: %s
//        ⏰ Время: %s
//
//        Все данные формы:
//        %s
//        """,
//                request.getName() != null ? request.getName() : "Не указано",
//                request.getEmail() != null ? request.getEmail() : "Не указано",
//                request.getMessage() != null ? request.getMessage() : "Не указано",
//                pageUrl != null ? pageUrl : "Неизвестно",
//                java.time.LocalDateTime.now(),
//                request.getAllFields().toString()
//        );
//    }
}
