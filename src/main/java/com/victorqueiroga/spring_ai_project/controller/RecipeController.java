package com.victorqueiroga.spring_ai_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victorqueiroga.spring_ai_project.service.RecipeService;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/get")
    public ResponseEntity<String> getRecipe(@RequestParam @NotBlank String ingredients) {
        String response = recipeService.getRecipe(ingredients);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/create")
    public ResponseEntity<String> createRecipe(@RequestParam @NotBlank String ingredients,
            @RequestParam @NotBlank String cuisineType,
            @RequestParam @NotBlank String dietaryRestrictions) {
        String response = recipeService.createRecipe(ingredients, cuisineType, dietaryRestrictions);
        return ResponseEntity.ok(response);
    }
}
