package com.example.cors_test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://fitxshapka.tilda.ws")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class ClientsController {

    @GetMapping("/info")
    public Map<String, Object> getUserInfo(@RequestParam String email) {
        return Map.of(
                "name", "Алексей",
                "email", email,
                "subscriptions", List.of(
                        Map.of("type", "Фитнес зал", "expires", "2025-12-31"),
                        Map.of("type", "Бассейн", "expires", "2025-11-15")
                )
        );
    }
}
