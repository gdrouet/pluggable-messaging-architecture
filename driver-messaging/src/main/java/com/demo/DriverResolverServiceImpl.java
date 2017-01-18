package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * This default {@link DriverResolverService} implementation uses the {@cod bean} name of the driver to resolve it.
 */
@Service
public class DriverResolverServiceImpl implements DriverResolverService {

    /**
     * Injects all the declared drivers in the container.
     */
    private final Map<String, Driver<? extends DriverRequest>> drivers;

    @Autowired
    public DriverResolverServiceImpl(final Map<String, Driver<? extends DriverRequest>> drivers) {
        this.drivers = drivers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DriverResolution resolve(final String name) {
        return new DriverResolution((Driver<DriverRequest>) drivers.get(name));
    }
}
