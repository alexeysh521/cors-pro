package com.example.cors_test.service;

import com.example.cors_test.persistence.model.FormSubmission;
import com.example.cors_test.persistence.repository.FormSubmissionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;


// Name=Алексей&Email=alex@gmail.com&Textarea=Привет&tranid=16757156:7888517302&formid=form1467857151

@Service
@RequiredArgsConstructor
public class FormProcessingService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final FormSubmissionRepository formSubmissionRepository;
    private final JavaMailSender mailSender;
    private final ObjectMapper objectMapper;


    @Transactional
    public ResponseEntity<Map<String, String>> handleTrainingRequest(Map<String, String> params) {
        String formId = params.getOrDefault("trainId", null);

        FormSubmission form = new FormSubmission();
        form.setTrainId(formId);
        form.setAllParams(params);

        formSubmissionRepository.save(form);

        LOGGER.info("Handling training request form={}", params);
        return ResponseEntity.ok(Map.of("status", "success", "message", "Заявка на тренировку сохранена"));
    }

    public ResponseEntity<Map<String, String>> handleContactRequest(Map<String, String> params) {
        // логика обратной связи
        return ResponseEntity.ok(Map.of("status", "success", "message", "Сообщение получено"));
    }

    public ResponseEntity<Map<String, String>> handleFoodOrder(Map<String, String> params) {
        // логика обработки заказа
        return ResponseEntity.ok(Map.of("status", "success", "message", "Заказ принят в обработку"));
    }


//    private String createEmailText(FormSubmission request) {
//        return String.format("""
//        🏋️ Новая заявка на тренировку
//        --------------------
//        📝 Имя: %s
//        📧 Email: %s
//        💬 Комментарий: %s
//        ⏰ Время: %s
//        """,
//                request.getName() != null ? request.getName() : "Не указано",
//                request.getEmail() != null ? request.getEmail() : "Не указано",
//                request.getTextArea() != null ? request.getTextArea() : "Не указано",
//                java.time.LocalDateTime.now()
//        );
//    }
}
