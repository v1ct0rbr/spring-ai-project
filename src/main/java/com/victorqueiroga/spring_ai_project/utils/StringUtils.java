package com.victorqueiroga.spring_ai_project.utils;

public class StringUtils {

    /**
     * Checks if a given prompt is valid (not null and not empty).
     *
     * @param prompt the prompt to check
     * @return true if the prompt is valid, false otherwise
     */
    public static boolean isValidPrompt(String prompt) {
        return prompt != null && !prompt.trim().isEmpty();
    }

    /**
     * Checks if a given response is valid (not null and not empty).
     *
     * @param response the response to check
     * @return true if the response is valid, false otherwise
     */
    public static boolean isValidResponse(String response) {
        return response != null && !response.trim().isEmpty();
    }

}
