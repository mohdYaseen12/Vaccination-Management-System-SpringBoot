package com.example.vaccineManagementSystem.Dtos.RequestDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentReqDto {
    int docId;
    int userId;
    Date appointmentDate;
    LocalTime apppointmentTime;
}
