package com.example.vaccineManagementSystem.Models;

import com.example.vaccineManagementSystem.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     int docId;

     String name;

     @Column(unique = true)
     String emailId;

     @Enumerated(EnumType.STRING)
     Gender gender;

     @ManyToOne
     @JoinColumn
     VaccinationCenter vaccinationCenter;

     @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
     List<Appointment> appointmentList = new ArrayList<>();




}
