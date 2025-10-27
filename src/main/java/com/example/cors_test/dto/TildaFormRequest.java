package com.example.cors_test.dto;

import lombok.Data;

import java.util.Map;

@Deprecated
@Data
public class TildaFormRequest {
    private String name;
    private String email;
    private String message;
    private Map<String, String> allFields;


    public TildaFormRequest(Map<String, String> allParams) {
        this.name = allParams.get("name");
        this.email = allParams.get("email");
        this.message = allParams.get("message");
        this.allFields = allParams;
    }
}
