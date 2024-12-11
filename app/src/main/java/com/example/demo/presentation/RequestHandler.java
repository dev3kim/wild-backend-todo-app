package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements HttpHandler {

    private final Map<String, TodoItemsContentCreator> contents = new HashMap<>();

    public RequestHandler() {
        this.contents.put("POST /todoItems", new TodoItemsCreateContentCreator());
        this.contents.put("GET /todoItems", new TodoItemsGetContentCreator());
        this.contents.put("default", new DefaultContentCreator());
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        //POST /todoItems, GET /todoItems 구분 필요
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        String key = method + " " + path;
        if(!this.contents.containsKey(key)) {
            key = "default";
        }

        TodoItemsContentCreator contentCreator = this.contents.get(key);
        String content = contentCreator.createContent();
        byte[] bytes = content.getBytes();

        exchange.sendResponseHeaders(200, bytes.length);
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(bytes);
        responseBody.close();

        //curl -i -X POST -d '{"item": "study wildbackend", "isDone": false}' localhost:8080/todoItems
        //json requestBody 받아서 dto로 변환

    }
}
