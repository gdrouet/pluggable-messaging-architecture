package com.demo;

public interface AckService {

    void ack(DriverResponse response);

    void nack();
}
