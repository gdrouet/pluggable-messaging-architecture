package com.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * An emitter that detects new messages to treat.
 * This implementation is designed to poll every 5 seconds a system in order to detect messages.
 * In this example, we generate an arbitrary message with a 'route' header containing the name of the driver implementation
 * to invoke. In the future, a connector to a {@code MoM} can be considered.
 */
@EnableBinding(Source.class)
public class MessageEmitter {

    /**
     * Polls the system.
     *
     * @return the new message to emit
     */
    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "5000"))
    public MessageSource<String> timerMessageSource() {
        final Map<String, Object> headers = new HashMap<>();
        headers.put("route", "demo");
        return () -> new GenericMessage<>("{}", headers);
    }
}
