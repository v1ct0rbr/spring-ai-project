
package com.victorqueiroga.spring_ai_project.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatModel chatModel;

    public String getResponse(String prompt) {
        return chatModel.call(prompt);
    }

    public String getResponseWithOptions(String prompt) {
        ChatResponse response = chatModel.call(
                new Prompt(prompt,
                        OpenAiChatOptions.builder().model("gpt-4o-mini")
                                .temperature(0.4)
                                .build()));
        return response.getResult().getOutput().getText();
    }

}
