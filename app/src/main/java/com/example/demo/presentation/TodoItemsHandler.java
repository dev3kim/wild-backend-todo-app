package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;

public interface TodoItemsHandler {
    String handle(String requestBody);
}
