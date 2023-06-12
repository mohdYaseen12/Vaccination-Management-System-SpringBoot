package com.example.vaccineManagementSystem.Repository;

import com.example.vaccineManagementSystem.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Doctor findByEmailId(String emailId);
}
