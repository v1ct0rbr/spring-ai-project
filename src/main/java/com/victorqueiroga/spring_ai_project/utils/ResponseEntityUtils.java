package com.victorqueiroga.spring_ai_project.utils;

import lombok.Data;

@Data
public class ResponseEntityUtils<T> {

    public static final Integer TYPE_MESSAGE_SUCCESS = 1;
    public static final Integer TYPE_MESSAGE_ERROR = 2;
    public static final Integer TYPE_MESSAGE_WARNING = 3;

    private T body;
    private String message;
    private Integer typeMessage;

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {

        private final ResponseEntityUtils<T> responseEntityUtils = new ResponseEntityUtils<>();

        public Builder<T> body(T body) {
            responseEntityUtils.setBody(body);
            return this;
        }

        public Builder<T> message(String message) {
            responseEntityUtils.setMessage(message);
            return this;
        }

        public Builder<T> typeMessage(Integer typeMessage) {
            responseEntityUtils.setTypeMessage(typeMessage);
            return this;
        }

        public ResponseEntityUtils<T> build() {
            return responseEntityUtils;
        }
    }
}
