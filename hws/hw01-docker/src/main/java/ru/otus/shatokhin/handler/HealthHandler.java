package ru.otus.shatokhin.handler;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HealthHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        if ("GET".equalsIgnoreCase(requestMethod)) {
            Headers responseHeaders = exchange.getResponseHeaders();
            responseHeaders.set("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, 0);

            try (OutputStream responseBody = exchange.getResponseBody()) {
                responseBody.write("Welcome to first homework of the course Microservice Architecture".getBytes());
            }
        }
    }
}
