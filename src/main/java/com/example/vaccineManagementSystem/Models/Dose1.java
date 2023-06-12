package com.example.vaccineManagementSystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Dose1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String name;

    private int age;

    @Column(unique = true)
    private String emailId;


}
