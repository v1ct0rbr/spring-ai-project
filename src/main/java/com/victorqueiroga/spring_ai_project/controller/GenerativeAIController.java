package com.victorqueiroga.spring_ai_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victorqueiroga.spring_ai_project.service.ChatService;
import com.victorqueiroga.spring_ai_project.utils.ResponseEntityUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/prompt")
@RequiredArgsConstructor
public class GenerativeAIController {

    private final ChatService chatService;

    @GetMapping("/ask-ai")
    public ResponseEntity<ResponseEntityUtils<String>> chat(@RequestParam String prompt) {
        String response = chatService.getResponse(prompt);
        return ResponseEntity.ok(
                ResponseEntityUtils.<String>builder()
                        .body(response)
                        .message("Response from AI")
                        .typeMessage(ResponseEntityUtils.TYPE_MESSAGE_SUCCESS)
                        .build()
        );
    }

    @GetMapping("/ask-ai-with-model")
    public ResponseEntity<ResponseEntityUtils<String>> chatWithModel(@RequestParam String prompt) {
        try {
            String response = chatService.getResponseWithOptions(prompt);
            return ResponseEntity.ok(
                    ResponseEntityUtils.<String>builder()
                            .body(response)
                            .message("Response from AI with model")
                            .typeMessage(ResponseEntityUtils.TYPE_MESSAGE_SUCCESS)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    ResponseEntityUtils.<String>builder()
                            .body(null)
                            .message("Error: " + e.getMessage())
                            .typeMessage(ResponseEntityUtils.TYPE_MESSAGE_ERROR)
                            .build()
            );
        }

    }
}
