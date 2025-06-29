
package com.victorqueiroga.spring_ai_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victorqueiroga.spring_ai_project.service.ChatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/prompt")
@RequiredArgsConstructor
public class GenerativeAIController {

    private final ChatService chatService;

    @GetMapping("/ask-ai")
    public ResponseEntity<String> chat(@RequestParam String prompt) {
        String response = chatService.getResponse(prompt);
        return ResponseEntity.ok(response);
    }
}