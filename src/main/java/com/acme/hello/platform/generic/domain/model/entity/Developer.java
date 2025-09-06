package com.acme.hello.platform.generic.domain.model.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Represents a developer with a unique identifier, first name, and last name in the Generic bounded context.
 * This class provides methods to retrieve the full name and check for blank or empty names.
 *
 * @author Open-Source Applications Development Team
 * @version 1.0.0
 * @since 2025-09-06
 */
public class Developer {
    private final UUID id = UUID.randomUUID();
    private final String firstName;
    private final String lastName;

    /**
     * Constructor to initialize a Developer with first and last names.
     * @param firstName The first name of the developer.
     * @param lastName The last name of the developer.
     */
    public Developer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the full name of the developer by concatenating first and last names.
     * @return The full name of the developer.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Checks if either the first name or last name is blank (null, empty, or whitespace only).
     * @return True if either name is blank, false otherwise.
     */
    public boolean hasAnyNameBlank() {
        return StringUtils.isAnyBlank(firstName, lastName);
    }

    /**
     * Checks if either the first name or last name is empty (null or empty).
     * @return True if either name is empty, false otherwise.
     */
    public boolean hasAnyNameEmpty() {
        return StringUtils.isAnyEmpty(firstName, lastName);
    }

}
