package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An {@link AckService} that just logs ACK or NACK.
 */
public class AckServiceImpl implements AckService {

    /**
     * Logger.
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * {@inheritDoc}
     */
    @Override
    public void ack(final DriverResponse response) {
        logger.info("ACK");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void nack() {
        logger.info("NACK");
    }
}
