package com.example.demo.presentation.dto;

public class TodoItemDto {
    private int seq;
    private String item;
    private boolean isDone;

    public int getSeq() {
        return seq;
    }

    public String getItem() {
        return item;
    }

    public boolean isDone() {
        return isDone;
    }

    @Override
    public String toString() {
        return "seq=" + seq + "item=" + item + ", isDone=" + isDone;
    }
}
