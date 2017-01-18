package com.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The container must scan a {@code bean} that IS-A {@link Driver}.
 * To make sure the right package is scanned, a convention between the two parties can be established in order to always
 * use the same package. In this example, the common package is {@code com.demo} and spring is configured here to scan it.
 */
@Configuration
@ComponentScan(basePackageClasses = DriverTestConfig.class)
public class DriverTestConfig {
}
