package com.demo;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * A base class providing the basic environment set by the container when the driver is executed.
 *
 * @param <T> the type of parameter defined by the driver
 * @see DriverTestConfig
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DriverTestConfig.class)
public abstract class AbstractDriverTest<T extends DriverRequest> {

    /**
     * Inject the driver that must be resolved as a component.
     */
    @Autowired
    protected Driver<T> driver;
}
