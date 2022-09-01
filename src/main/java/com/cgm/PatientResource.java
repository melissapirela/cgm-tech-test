package com.cgm;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/patient")
@Produces("application/json")
@Consumes("application/json")
public class PatientResource {

    @Inject
    PatientService patientService;

    @GET
    @Operation(summary = "Gets patients", description = "Lists all available patients")
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Successful response",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = PatientDTO.class))))
    public List<PatientDTO> getPatients() {
        return patientService.getPatients();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Gets a patient given an id", description = "Retrieves a patient by id")
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Successful response",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PatientDTO.class))),
        @APIResponse(responseCode = "404", description = "Patient not found")
    })
    public PatientDTO getPatient(Integer id) {
        return patientService.getPatient(id);
    }

    @POST
    @Path("/{id}/visit")
    @Operation(summary = "Saves a patient's visit given his id", description = "Saves a patient's visit by his id")
    @APIResponses(value = {
        @APIResponse(responseCode = "201", description = "Successful response"),
        @APIResponse(responseCode = "400", description = "Error in the DTO for visit"),
        @APIResponse(responseCode = "404", description = "Patient not found")
    })
    public Response savePatientVisit(Integer id, VisitDTO visitDTO) {
        patientService.saveVisit(id, visitDTO);
        return Response.status(201).build();
    }

}