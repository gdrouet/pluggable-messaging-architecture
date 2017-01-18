package com.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * A resolved driver that can be invoked with a raw parameter.
 */
public class DriverResolution {

    /**
     * The invokable driver.
     */
    private Driver<DriverRequest> resolvedDriver;

    /**
     * Builds a new instance.
     *
     * @param resolvedDriver the driver
     */
    public DriverResolution(final Driver<DriverRequest> resolvedDriver) {
        this.resolvedDriver = resolvedDriver;
    }

    /**
     * <p>
     * Invokes {@link Driver#create(DriverRequest)} with a given JSON {@code String} to be converted to the type defined by
     * the driver using the specified {@code ObjectMapper}.
     * </p>
     *
     * @param rawJson the JSON {@code String}
     * @param ackService the acknowledgement service
     * @param mapper the mapper
     * @return the invocation result
     * @throws IOException if {@code ObjectMapper} fails to read JSON
     */
    public DriverResponse invoke(final String rawJson, final AckService ackService, final ObjectMapper mapper)
            throws IOException {
        final DriverRequest request = mapper.readValue(rawJson, resolvedDriver.getPayloadType());
        request.setAckService(ackService);
        return resolvedDriver.create(request);
    }
}
