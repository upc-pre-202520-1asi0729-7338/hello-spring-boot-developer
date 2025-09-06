package com.acme.hello.platform.generic.interfaces.rest.resources;

import java.util.UUID;

/**
 * Response object for greeting a developer.
 *
 * @param id       The unique identifier of the developer.
 * @param fullName The full name of the developer.
 * @param message  The greeting message.
 *
 * @summary
 * A record representing the response for greeting a developer, including their ID, full name, and a greeting message.
 *
 * @author Open-Source Application Development Team
 * @version 1.0
 * @since 20254-09-06
 */
public record GreetDeveloperResponse(UUID id, String fullName, String message) {

    public GreetDeveloperResponse(String message) {
        this(null, null, message);
    }
}
