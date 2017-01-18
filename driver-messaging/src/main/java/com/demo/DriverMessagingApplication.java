package com.demo;

import com.messaging.MessageEmitter;
import com.messaging.MessageReceiver;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.aggregate.AggregateApplicationBuilder;

/**
 * Main class that launch the application.
 * Please note that {@link MessageEmitter} and {@link MessageReceiver} must not be scanned by spring because they
 * are manually bounded with the  {@code AggregateApplicationBuilder}. That's why both of them are declared in a
 * different package called {@code com.messaging}.
 */
@SpringBootApplication
public class DriverMessagingApplication {

    /**
     * Main method.
     *
     * @param args arguments passed to spring container
     */
	public static void main(String[] args) {
		new AggregateApplicationBuilder(DriverMessagingApplication.class)
                .from(MessageEmitter.class)
                .to(MessageReceiver.class).run(args);
	}
}
