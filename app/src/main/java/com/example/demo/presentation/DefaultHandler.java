package com.example.demo.presentation;

public class DefaultHandler implements TodoItemsHandler {
    public static final String KEY = "default";

    @Override
    public String handle(String requestBody) {
        return "Hollo, World!";
    }
}
