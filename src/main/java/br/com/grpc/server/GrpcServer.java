package br.com.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

    public static void main(final String[] args) {
        final Server server = ServerBuilder.forPort(8080).addService(new HelloServiceImpl()).build();

        try {
            server.start();
            System.out.println("Server started on port 8080");
            server.awaitTermination();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

}
