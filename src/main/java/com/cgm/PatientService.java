package com.cgm;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;

@ApplicationScoped
public class PatientService {

  @Inject
  EntityManager entityManager;

  public List<PatientDTO> getPatients() {
    List<Patient> patients = entityManager.createNamedQuery("Patient.findAll", Patient.class)
        .getResultList();

    return patients.stream().map(this::mapPatientToPatientDTO).collect(Collectors.toList());
  }

  public PatientDTO getPatient(Integer id) {
    Patient patient = getPatientEntity(id);

    return mapPatientToPatientDTO(patient);
  }

  @Transactional
  public void saveVisit(Integer id, VisitDTO visitDTO) {
    getPatientEntity(id);
    entityManager.persist(mapVisitDTOToVisit(id, visitDTO));
  }

  private Patient getPatientEntity(Integer id) throws WebApplicationException {
    Patient patient = entityManager.find(Patient.class, id);
    if (patient == null) {
      throw new WebApplicationException("Patient with id " + id + " does not exist.", 404);
    }
    return patient;
  }

  private PatientDTO mapPatientToPatientDTO(Patient patient) {
    return PatientDTO.builder()
        .id(patient.getId())
        .name(patient.getName())
        .surname(patient.getSurname())
        .dateOfBirth(patient.getDateOfBirth())
        .socialSecurityNumber(patient.getSocialSecurityNumber())
        .build();
  }

  private Visit mapVisitDTOToVisit(Integer patientId, VisitDTO visitDTO) {
    return Visit.builder()
        .patientId(patientId)
        .date(visitDTO.getDate())
        .time(visitDTO.getTime())
        .type(visitDTO.getType().name())
        .reason(visitDTO.getReason().name())
        .familyHistory(visitDTO.getFamilyHistory())
        .build();
  }
}