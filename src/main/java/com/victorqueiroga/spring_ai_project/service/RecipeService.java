package com.victorqueiroga.spring_ai_project.service;

import java.util.Map;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final ChatModel chatModel;

    public String getRecipe(String ingredients) {
        String prompt = "Generate a recipe using the following ingredients: " + ingredients;
        return chatModel.call(prompt);
    }

    public String createRecipe(String ingredients, String cuisineType, String dietaryRestrictions) {

        var template = """
                I want to create a recipe using the following ingredients: {ingredients}.
                The cuisine type I prefer is {cuisineType}.
                Please consider the following dietary restrictions: {dietaryRestrictions}.
                Please provide me with a detailed recipe including title, list of ingredients, and cooking instructions.
                """;
        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
                "ingredients", ingredients,
                "cuisineType", cuisineType,
                "dietaryRestrictions", dietaryRestrictions
        );
        Prompt prompt = promptTemplate.create(params);

        return chatModel.call(prompt).getResult().getOutput().getText();
    }
}
