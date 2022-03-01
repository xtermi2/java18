package com.github.xtermi2.java18.jep408simplewebserver;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

import java.net.InetSocketAddress;
import java.nio.file.Path;

public class SimpleWebServer {
    public static void main(String[] args) {
        final HttpServer server = SimpleFileServer.createFileServer(
                new InetSocketAddress(8000),
                Path.of(System.getProperty("user.home")),
                SimpleFileServer.OutputLevel.INFO);
        server.start();
    }
}
