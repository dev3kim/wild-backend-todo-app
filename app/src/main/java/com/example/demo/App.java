package com.example.demo;

import com.example.demo.presentation.RequestHandler;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

@Configuration
@ComponentScan
public class App {

    /*
        curl -i -X POST -d '{"seq": 1, "item": "study wildbackend100", "isDone": false}' localhost:8080/todoItems
        curl -i -X GET localhost:8080/todoItems
        curl -i -X GET localhost:8080/test
    */

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class); //config 잡아줘야함
        Server server = context.getBean(Server.class);   //app instance
        server.run();
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
