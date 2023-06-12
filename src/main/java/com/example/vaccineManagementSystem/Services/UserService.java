package com.example.vaccineManagementSystem.Services;

import com.example.vaccineManagementSystem.Models.Dose;
import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User addUser(User user) {
        user = userRepository.save(user);
        return user;
    }

    public Date getVaccinationDate(Integer userId) {
        User user = userRepository.findById(userId).get();
        Dose dose = user.getDose();
        return dose.getVaccinationDate();
    }
}