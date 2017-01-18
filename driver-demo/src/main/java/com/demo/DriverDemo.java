package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of the {@link Driver} interface.
 *
 * It's very important that the {@code bean} is named with the message type the container will check to route proper
 * requests to it. In this example, the message type is {@code demo} and is specified via the {@code @Component} annotation.
 * Other approaches like creating it via a {@code @Bean} method in a {@code @Configuration} class are possible.
 *
 * What is also important is to make sure the container will scan the package where the implementation is located.
 * To avoid extra configuration, everyone can use the same package. In this example the container scan the {@code com.demo}
 * package so this implementation has to be delcared in the {@code com.demo} package also.
 */
@Component("demo")
public class DriverDemo implements Driver<DriverRequestDemo> {

    /**
     * Logger.
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Example of injection that is expected to work inside the container.
     * {@code RestTemplate} is handy for calling a third party service and is a reason why spring-web module is declared
     * as a dependency in the important library.
     */
    private final RestTemplate restTemplate;

    @Autowired
    public DriverDemo(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * {@inheritDoc}
     */
    public DriverResponse create(final DriverRequestDemo payload) {
        logger.info("Demo Driver invoked.");

        // Manual acknowledge
        payload.getAckService().ack(null);

        return new DriverResponse();
    }

    /**
     * {@inheritDoc}
     */
    public Class<DriverRequestDemo> getPayloadType() {
        return DriverRequestDemo.class;
    }
}