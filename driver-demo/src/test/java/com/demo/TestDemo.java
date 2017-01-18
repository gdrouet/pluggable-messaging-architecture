package com.demo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Example of unit test that can be implemented by the driver implementation to simulate the execution inside the
 * container.
 */
public class TestDemo extends AbstractDriverTest<DriverRequestDemo> {

    /**
     * This test has access to the autowired {@code Driver} implementation resolved by the contaienr.
     */
    @Test
    public void assertTest() {
        final DriverRequestDemo request = new DriverRequestDemo();
        request.setAckService(new AckService() {
            public void ack(DriverResponse response) {

            }

            public void nack() {

            }
        });

        Assert.assertNotNull(driver.create(request));
    }
}
