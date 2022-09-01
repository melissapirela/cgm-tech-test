package com.cgm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class VisitDTO {

  private String date;
  private String time;
  private VisitType type;
  private VisitReason reason;
  private String familyHistory;

}
