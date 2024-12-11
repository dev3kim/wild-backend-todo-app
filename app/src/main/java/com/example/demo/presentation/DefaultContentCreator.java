package com.example.demo.presentation;

public class DefaultContentCreator implements TodoItemsContentCreator {
    @Override
    public String createContent() {
        return "Hollo, World!";
    }
}
