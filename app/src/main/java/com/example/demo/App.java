package com.example.demo;

import com.example.demo.presentation.RequestHandler;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {

        //app 실행
        App app = new App();
        app.run();
    }

    public void run() throws IOException {
        //API 설계
        //resource: todoItems
        //할일 등록: POST /todoItems
        //할일 조회: GET /todoItems

        /*
            curl -i -X POST -d '{"seq": 1, "item": "study wildbackend100", "isDone": false}' localhost:8080/todoItems
            curl -i -X GET localhost:8080/todoItems
        */


        //curl -i localhost:8080 -> 응답없음 -> 웹서버생성
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8080), -1); //주소, backlog -1 설정
        //No context found for request -> context 등록
        //No handler for context -> requestHandler 생성
        //requestHandler 어떻게 하더라? exchange가 필요한데... -> createContext 호출 시 handler 생성
        //응답 주기 -> responseBody
        //curl: (52) Empty reply from server -> header body 순서 거꾸로됨
        httpServer.createContext("/", new RequestHandler());

        httpServer.start();

        /*
        3계층
            1. presentation layer
                -> 등록, 조회 handler 분리 HttpHandler 구현
            2. application layer
                -> items 추가, 조회
            3. data layer
        */

        System.out.println("server listening~~");
    }
}
