package com.cgm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "visit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Visit {

  @Id
  @SequenceGenerator(name = "visitIdSequence", sequenceName = "visit_id_seq", allocationSize = 1, initialValue = 10)
  @GeneratedValue(generator = "visitIdSequence")
  private Integer id;

  private Integer patientId;

  @Column(length = 10)
  private String date;

  @Column(length = 10)
  private String time;

  @Column(length = 20)
  private String type;

  @Column(length = 20)
  private String reason;

  @Column(length = 1000)
  private String familyHistory;
}
