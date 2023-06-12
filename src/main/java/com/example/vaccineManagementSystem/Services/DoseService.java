package com.example.vaccineManagementSystem.Services;

import com.example.vaccineManagementSystem.Models.Dose;
import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Repository.DoseRepository;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {
    @Autowired
    private DoseRepository doseRepository;

    @Autowired
    private UserRepository userRepository;
    public String giveDose(Integer doseId, Integer userId) {
        User user = userRepository.findById(userId).get();

        Dose dose = new Dose();

        dose.setUser(user);
        dose.setDoseId(doseId);

        user.setDose(dose);

        userRepository.save(user);
        // child will automatically get saved due to cascading effect.
        return "Dose Given to User Successfully";

    }
}
