package com.acme.hello.platform.generic.interfaces.rest.assemblers;

import com.acme.hello.platform.generic.domain.model.entity.Developer;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperResponse;
import org.apache.commons.lang3.ObjectUtils;

/**
 * Assembler class to convert Developer entities to GreetDeveloperResponse resources.
 * This class provides methods to create response objects based on the state of the Developer entity.
 *
 * @author Open-Source Applications Development Team
 * @version 1.0.0
 * @since 2025-09-06
 */
public class GreetDeveloperResponseAssembler {

    /**
     * Checks if the Developer entity is null or has empty/blank names.
     *
     * @param entity The {@link Developer} entity to check.
     * @return True if the entity is null or has empty/blank names, false otherwise.
     */
    private static boolean isDeveloperNullOrEmptyNamed(Developer entity) {
        return ObjectUtils.isEmpty(entity)
                || entity.hasAnyNameBlank()
                || entity.hasAnyNameEmpty();
    }

    /**
     * Converts a Developer entity to a GreetDeveloperResponse resource.
     * If the entity is null or has empty/blank names, returns a default anonymous response.
     *
     * @param entity The {@link Developer} entity to convert.
     * @return A {@link GreetDeveloperResponse} resource representing the developer.
     */
    public static GreetDeveloperResponse toResponseFromEntity(Developer entity) {
        if (isDeveloperNullOrEmptyNamed(entity))
            return new GreetDeveloperResponse("Welcome Anonymous Spring Boot Developer");
        return new GreetDeveloperResponse(entity.getId(), entity.getFullName(),
                "Congrats " + entity.getFullName() + "! You are a Spring Boot Developer!");
    }
}
