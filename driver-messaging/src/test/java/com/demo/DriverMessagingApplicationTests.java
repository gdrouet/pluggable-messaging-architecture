package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test class for the container.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class DriverMessagingApplicationTests {

    /**
     * Handler to call.
     */
	@Autowired
    private DriverMessageHandler driverMessageHandler;

    /**
     * Simulates a message handling.
     */
	@Test
	public void handleMessage() {
	    final DriverMessage driverMessage = new DriverMessage();
	    driverMessage.setDriverName("demo");
	    driverMessage.setPayload("{}");
	    driverMessageHandler.handle(driverMessage);
	}
}
