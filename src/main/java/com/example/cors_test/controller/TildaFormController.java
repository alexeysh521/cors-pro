package com.example.cors_test.controller;

import com.example.cors_test.service.FormProcessingService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tilda")
public class TildaFormController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final FormProcessingService formProcessingService;

    // http://localhost/8080/api/tilda/submit
    // https://webjack.ru/webhooks/tilda/b8ac8aec7c14401d9e7c7b6739f41eda/
    // Name=Алексей&Email=alex@gmail.com&Textarea=Привет&tranid=16757156:7888517302&formid=form1467857151
    @PostMapping("/submit")
    public ResponseEntity<Map<String, String>> handleFormSubmission(
            @RequestParam Map<String, String> allParams){

        String formId = allParams.get("formid");
        LOGGER.info("📩 Получена форма: {}", formId);

        if (formId == null) {
            LOGGER.error("No resource found");
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "error",
                    "message", "Не указан formid"
            ));
        }

        switch (formId) {
            case "form1467857151" -> {
                // форма "Заявка на тренировку"
                return formProcessingService.handleTrainingRequest(allParams);
            }
            case "form1467857152" -> {
                // форма ""
                return formProcessingService.handleContactRequest(allParams);
            }
            case "form1467857153" -> {
                // форма "Онлайн-заказ еды"
                return formProcessingService.handleFoodOrder(allParams);
            }
            default -> {
                LOGGER.warn("Неизвестная форма: {}", formId);
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "error",
                        "message", "Неизвестная форма: " + formId
                ));
            }
        }
    }

//    @PostMapping("/submit")
//    public ResponseEntity<Map<String, String>> handleFormSubmission1(
//            @RequestParam Map<String, String> allParams,
//            @RequestHeader(value = "Referer", required = false) String pageUrl) {
//
//        String formName = allParams.getOrDefault("formname", "unknown");
//        LOGGER.info("Получена форма: {}", formName);
//        LOGGER.info("Получено url: {}", pageUrl);
//
//        return ResponseEntity.ok(Map.of("status", "success"));
//    }
//
//
//    //secret-key X-API-KEY
//    //@PostMapping("/submit")
//    public ResponseEntity<Map<String, String>> handleFormSubmission(
//            @RequestParam Map<String, String> allParams,
//            @RequestHeader(value = "Referer", required = false) String pageUrl) {
//
//        // Логируем ВСЕ пришедшие параметры
//        LOGGER.info("=== FORM DATA FROM TILDA ===");
//        allParams.forEach((key, value) -> {
//            LOGGER.info("Field: {} = {}", key, value);
//        });
//        LOGGER.info("Page URL: {}", pageUrl);
//        LOGGER.info("=============================");
//
//        // Добавляем pageUrl в параметры для сохранения
//        allParams.put("pageurl", pageUrl);
//
//        try {
//            TildaFormRequest request = new TildaFormRequest(allParams);
//            formProcessingService.processForm(request, pageUrl);
//
//            return ResponseEntity.ok(Map.of(
//                    "status", "success",
//                    "message", "Заявка на тренировку отправлена! Мы свяжемся с вами в ближайшее время."
//            ));
//
//        } catch (Exception e) {
//            LOGGER.error("Error processing form", e);
//            return ResponseEntity.badRequest().body(Map.of(
//                    "status", "error",
//                    "message", "Ошибка при отправке заявки. Пожалуйста, попробуйте еще раз."
//            ));
//        }
//    }
//
//    // Специальный endpoint для контактной формы
//    @PostMapping("/contact")
//    public ResponseEntity<Map<String, String>> handleContactForm(
//            @RequestParam Map<String, String> allParams) {
//        return handleFormSubmission(allParams, null);
//    }
//
//    // Health check для тестирования
//    @GetMapping("/health")
//    public ResponseEntity<Map<String, String>> health() {
//        return ResponseEntity.ok(Map.of(
//                "status", "OK",
//                "service", "Tilda Forms Backend",
//                "timestamp", java.time.LocalDateTime.now().toString()
//        ));
//    }
}
