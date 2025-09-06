package com.acme.hello.platform.generic.interfaces.rest.assemblers;

import com.acme.hello.platform.generic.domain.model.entity.Developer;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperRequest;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class DeveloperAssembler {

    public static Developer toEntityFromRequest(GreetDeveloperRequest request) {
        if (ObjectUtils.isEmpty(request) || StringUtils.isAnyBlank(request.firstName(), request.lastName()))
            return null;
        return Developer.builder()
                .build()
                .withFirstName(request.firstName())
                .withLastName(request.lastName());

    }
}
