package com.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * This handler is in charge of message reception and synchronously call the right driver for each of them.
 */
@Component
public class DriverMessageHandler {

    /**
     * Logger.
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Driver resolver.
     */
    private final DriverResolverService driverResolverService;

    /**
     * JSON mapper.
     */
    private final ObjectMapper mapper;

    @Autowired
    public DriverMessageHandler(final DriverResolverService driverResolverService, final ObjectMapper mapper) {
        this.driverResolverService = driverResolverService;
        this.mapper = mapper;
    }

    /**
     * Handles a message.
     *
     * @param driverMessage the message
     * @return the result of {@link Driver#create(DriverRequest)} invocation, {@code null} in case of failure
     */
    public DriverResponse handle(final DriverMessage driverMessage) {
        try {
            return driverResolverService.resolve(driverMessage.getDriverName())
                    .invoke(driverMessage.getPayload(), driverMessage.getAckService(), mapper);
        } catch (IOException ioe) {
            logger.error("Unable to read payload", ioe);
            return null;
        }
    }
}
