package com.victorqueiroga.spring_ai_project.service;

import org.springframework.ai.chat.model.ChatModel;
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
        StringBuilder prompt = new StringBuilder("Create a recipe using the following ingredients: " + ingredients);

        if (cuisineType != null && !cuisineType.isEmpty()) {
            prompt.append(", cuisine type: ").append(cuisineType);
        }

        if (dietaryRestrictions != null && !dietaryRestrictions.isEmpty()) {
            prompt.append(", dietary restrictions: ").append(dietaryRestrictions);
        }

        return chatModel.call(prompt.toString());
    }
}
