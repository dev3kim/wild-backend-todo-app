package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements HttpHandler {

    private final Map<String, TodoItemsHandler> contents = new HashMap<>();

    public RequestHandler() {
        this.contents.put(TodoItemsSaveHandler.KEY, new TodoItemsSaveHandler());
        this.contents.put(TodoItemsGetHandler.KEY, new TodoItemsGetHandler());
        this.contents.put(DefaultHandler.KEY, new DefaultHandler());
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        //POST /todoItems, GET /todoItems 구분 필요
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        //reqeust uri 분석해서 어떤 resourceHandler가 처리해야하는지 판정
        String key = method + " " + path;
        if(!this.contents.containsKey(key)) {
            key = DefaultHandler.KEY;
        }

        TodoItemsHandler handler = this.contents.get(key);
        //byte -> string(json) -> dto
        String content = handler.handle(new String(exchange.getRequestBody().readAllBytes()));
        byte[] bytes = content.getBytes();

        exchange.sendResponseHeaders(200, bytes.length);
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(bytes);
        responseBody.close();
    }
}
