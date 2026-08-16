package com.devops.app;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {

            String response =
                    "AWS DevOps CI/CD Pipeline Application\n" +
                    "Application is running successfully in Docker!";

            exchange.sendResponseHeaders(200, response.getBytes().length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.start();

        System.out.println("AWS DevOps CI/CD Pipeline Application");
        System.out.println("Application started on port 8080");
    }
}
