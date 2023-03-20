package br.com.grpc.server;

import grpc.HelloRequest;
import grpc.HelloResponse;
import grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(final HelloRequest request, final StreamObserver<HelloResponse> responseObserver) {
        final String greeting = new StringBuilder().append("Olá, ").append(request.getFirstName()).append(" ").append(request.getLastName()).toString();

        final HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
