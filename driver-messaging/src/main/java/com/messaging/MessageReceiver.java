package com.messaging;

import com.demo.AckService;
import com.demo.AckServiceImpl;
import com.demo.DriverMessage;
import com.demo.DriverMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * Receives an emitted message and handle it with the correct driver.
 * This receiver is also responsible for acknowledgment service creation to let the driver manually acknowledging the
 * message. If the message can't be sent to the driver, this class automatically call {@link AckService#nack()}.
 */
@EnableBinding(Sink.class)
public class MessageReceiver {

    private final DriverMessageHandler driverMessageHandler;

    @Autowired
    public MessageReceiver(DriverMessageHandler driverMessageHandler) {
        this.driverMessageHandler = driverMessageHandler;
    }

    /**
     * Handles the message.
     *
     * @param message the message
     */
    @StreamListener(Sink.INPUT)
    public void handle(final Message<String> message) {
        final AckService ackService = resolveAckService(message);

        final DriverMessage driverMessage = new DriverMessage();
        driverMessage.setDriverName(message.getHeaders().get("route", String.class));
        driverMessage.setPayload(message.getPayload());
        driverMessage.setAckService(ackService);

        if (driverMessageHandler.handle(driverMessage) == null) {
            ackService.nack();
        }
    }

    /**
     * Example of {@link AckService} resolution. In this example we create a simple {@link AckServiceImpl} but in the
     * future we can extract from the headers a MoM-specific implementation like for Kafka.
     * See http://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#_example_setting_literal_autocommitoffset_literal_false_and_relying_on_manual_acking
     *
     * @param message the message to acknowledge
     * @return the acknowledge service for the message
     */
    private AckService resolveAckService(final Message<String> message) {
        return new AckServiceImpl();
    }
}
