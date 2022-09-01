package com.cgm;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "patient")
@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Patient {

  @Id
  @SequenceGenerator(name = "patientIdSequence", sequenceName = "patient_id_seq", allocationSize = 1, initialValue = 10)
  @GeneratedValue(generator = "patientIdSequence")
  private Integer id;

  @Column(length = 150)
  private String name;

  @Column(length = 150)
  private String surname;

  @Column(length = 10)
  private String dateOfBirth;

  @Column(length = 20)
  private String socialSecurityNumber;

}
