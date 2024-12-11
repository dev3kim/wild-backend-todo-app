package com.example.demo;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {

        //app 실행
        App app = new App();
        app.run();
    }

    public void run() throws IOException {
        System.out.println("Hello, world!");

        //curl -i localhost:8080 -> 응답없음 -> 웹서버생성
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8080), -1); //주소, backlog -1 설정
        //No context found for request -> context 등록
        httpServer.createContext("/");
        //No handler for context -> requestHandler 생성

        httpServer.start();

        //API 설계
        //resource: todoItems
        //할일 등록: POST /todoItems
        //할일 조회: GET /todoItems

        //curl -i -X POST localhost:8080/todoItems -> 404 Not Found -> requestHandler 만들어서 method와 path 인식하도록 처리

    }
}
