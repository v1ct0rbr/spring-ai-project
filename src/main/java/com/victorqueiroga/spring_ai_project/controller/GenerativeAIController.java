package com.victorqueiroga.spring_ai_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victorqueiroga.spring_ai_project.service.ChatService;
import com.victorqueiroga.spring_ai_project.utils.StringUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GenerativeAIController {

    private final ChatService chatService;

    @GetMapping("/ask-ai")
    public ResponseEntity<String> getResponse(@RequestParam String prompt) {
        try {
            if (!StringUtils.isValidPrompt(prompt)) {
                throw new IllegalArgumentException("Prompt cannot be null or empty");
            }
            String response = chatService.getResponse(prompt);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }

    }

    @GetMapping("/ask-ai-with-options")
    public ResponseEntity<String> getResponseWithOptions(@RequestParam String prompt) {
        try {
            String response = chatService.getResponseWithOptions(prompt);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

}
