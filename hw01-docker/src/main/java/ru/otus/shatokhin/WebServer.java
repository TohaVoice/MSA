package ru.otus.shatokhin;

import com.sun.net.httpserver.HttpServer;
import ru.otus.shatokhin.handler.HealthHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class WebServer {

    public static void main(String[] args) {
        InetSocketAddress addr = new InetSocketAddress(8000);
        HttpServer server = null;
        try {
            server = HttpServer.create(addr, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.createContext("/health", new HealthHandler());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Server is listening on port 8000" );
    }
}
