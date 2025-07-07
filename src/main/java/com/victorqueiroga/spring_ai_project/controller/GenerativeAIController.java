package com.victorqueiroga.spring_ai_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victorqueiroga.spring_ai_project.service.ChatService;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class GenerativeAIController {

    private final ChatService chatService;
   

    @GetMapping("/ask-ai")
    public ResponseEntity<String> getResponse(@RequestParam @NotBlank String prompt) {
        return ResponseEntity.ok(chatService.getResponse(prompt));

    }

    @GetMapping("/ask-ai-with-options")
    public ResponseEntity<String> getResponseWithOptions(@RequestParam @NotBlank String prompt) {
        String response = chatService.getResponseWithOptions(prompt);
        return ResponseEntity.ok(response);
    }

    

}
