package br.com.grpc.client;

import grpc.HelloRequest;
import grpc.HelloResponse;
import grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(final String[] args) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

        final HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        final HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder().setFirstName("Roberto").setLastName("Valdomiro").build());

        System.out.println(helloResponse.getGreeting());
        channel.shutdown();
    }

}
