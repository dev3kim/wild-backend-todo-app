package com.example.demo.data;

import java.util.ArrayList;
import java.util.List;

public class TodoItemRepository {
    private static final List<TodoItem> todoItems = new ArrayList<>();

    public void add(TodoItem todoItem) {
        todoItems.add(todoItem);
    }

    public List<TodoItem> get(){
        return todoItems;
    }
}
