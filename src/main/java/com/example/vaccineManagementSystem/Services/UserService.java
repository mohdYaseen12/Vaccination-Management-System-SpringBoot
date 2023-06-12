package com.example.vaccineManagementSystem.Services;

import com.example.vaccineManagementSystem.Dtos.RequestDtos.UpdateEmailDto;
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

    public String updateEmail(UpdateEmailDto updateEmailDto) {
        User user = userRepository.findById(updateEmailDto.getUserId()).get();
        user.setEmailId(updateEmailDto.getNewEmailId());

        userRepository.save(user);

        return "Old Email id is updated with " + updateEmailDto.getNewEmailId();
    }

    public User getUserByEmail(String emailId) {
        User user = userRepository.findByEmailId(emailId);
        return user;
    }
}
