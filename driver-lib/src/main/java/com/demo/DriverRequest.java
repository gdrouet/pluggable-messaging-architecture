package com.demo;

/**
 * A base class to represent driver request object types.
 * This allows to access an {@link AckService} contextualized to the request.
 */
public abstract class DriverRequest {

    /**
     * The contextualized acknowledgment service.
     */
    private AckService ackService;

    public AckService getAckService() {
        return ackService;
    }

    public void setAckService(AckService ackService) {
        this.ackService = ackService;
    }
}
