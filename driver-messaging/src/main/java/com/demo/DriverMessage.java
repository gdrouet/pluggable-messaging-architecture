package com.demo;

/**
 * A driver message has a name to resolve, a payload to use as parameter and an {@link AckService} to acknowledge message.
 */
public class DriverMessage {

    /**
     * The name to resolve.
     */
    private String driverName;

    /**
     * The data to pass to the driver.
     */
    private String payload;

    /**
     * The acknowledgment service.
     */
    private AckService ackService;

    public void setDriverName(final String driverName) {
        this.driverName = driverName;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getPayload() {
        return payload;
    }

    public AckService getAckService() {
        return ackService;
    }

    public void setAckService(AckService ackService) {
        this.ackService = ackService;
    }
}
