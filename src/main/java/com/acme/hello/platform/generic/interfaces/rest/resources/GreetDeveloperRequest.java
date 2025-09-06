package com.acme.hello.platform.generic.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Request object for greeting a developer.
 *
 * @param firstName The first name of the developer.
 * @param lastName  The last name of the developer.
 */
public record GreetDeveloperRequest(
        String firstName,
        String lastName) {

    /**
     * Constructs a new {@code GreetDeveloperRequest} instance.
     *
     * @param firstName The first name of the developer.
     * @param lastName  The last name of the developer.
     */
    @JsonCreator
    public GreetDeveloperRequest(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
