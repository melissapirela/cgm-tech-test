package com.cgm.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
    tags = {
        @Tag(name = "patient", description = "Patient operations."),
        @Tag(name = "visit", description = "Visit operations."),
    },
    info = @Info(
        title = "Technical task for CGM Tech Lead position with Quarkus",
        version = "0.0.1",
        contact = @Contact(
            name = "Melissa Pirela"))
)
public class SwaggerConfig extends Application {

}
