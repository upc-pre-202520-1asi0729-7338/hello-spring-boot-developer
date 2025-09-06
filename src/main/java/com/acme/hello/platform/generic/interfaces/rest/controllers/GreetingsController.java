package com.acme.hello.platform.generic.interfaces.rest.controllers;

import com.acme.hello.platform.generic.domain.model.entity.Developer;
import com.acme.hello.platform.generic.interfaces.rest.assemblers.DeveloperAssembler;
import com.acme.hello.platform.generic.interfaces.rest.assemblers.GreetDeveloperResponseAssembler;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperRequest;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping( path = "/api/v1/greetings", produces = MediaType.APPLICATION_JSON_VALUE)
public class GreetingsController {

    @GetMapping
    public ResponseEntity<GreetDeveloperResponse> greetDeveloper(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        Developer developer = (Objects.isNull(firstName) || Objects.isNull(lastName))
                ? null
                : Developer.builder().build().withFirstName(firstName).withLastName(lastName);
        GreetDeveloperResponse response = GreetDeveloperResponseAssembler.toResponseFromEntity(developer);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GreetDeveloperResponse> createGreeting(@RequestBody GreetDeveloperRequest request) {
        Developer developer = DeveloperAssembler.toEntityFromRequest(request);
        GreetDeveloperResponse response = GreetDeveloperResponseAssembler.toResponseFromEntity(developer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
