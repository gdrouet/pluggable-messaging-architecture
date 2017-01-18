package com.demo;

/**
 * A service that resolved the right {@code Driver} for a given name.
 */
public interface DriverResolverService {

    /**
     * Resolves the driver.
     *
     * @param name the name to resolve
     * @return resolution result
     */
    DriverResolution resolve(String name);
}
