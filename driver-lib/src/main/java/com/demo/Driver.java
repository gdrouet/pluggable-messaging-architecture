package com.demo;

/**
 * This interface has to be implemented by each driver.
 * Parameter of each function can be generic and defined by the driver itself.
 * However the returned type is standard and defined in this library.
 *
 * @param <T>
 */
public interface Driver<T extends DriverRequest> {

    /**
     * Example of method to be implemented by the driver.
     *
     * @param payload the data with a structure defined by the driver
     * @return the expected result in a particular format
     */
    DriverResponse create(T payload);

    /**
     * This allows to retrieve the expected parameter type after type erasure and perform serialization with the proper
     * {@code Class}.
     *
     * @return the parameter class type
     */
    Class<T> getPayloadType();
}
