package com.example.demo.presentation;

import com.example.demo.application.TodoItemService;
import com.example.demo.data.TodoItem;
import com.google.gson.Gson;

import java.util.List;

public class TodoItemsGetHandler implements TodoItemsHandler {
    public static final String KEY = "GET /todoItems";

    @Override
    public String handle(String requestBody) {
        //application layer 에게 get요청
        TodoItemService todoItemService = new TodoItemService();
        List<TodoItem> retrieve = todoItemService.retrieve();
        Gson gson = new Gson();

        return gson.toJson(retrieve);
    }
}
