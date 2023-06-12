package com.example.vaccineManagementSystem.Repository;

import com.example.vaccineManagementSystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
