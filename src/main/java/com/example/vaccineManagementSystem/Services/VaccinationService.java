package com.example.vaccineManagementSystem.Services;

import com.example.vaccineManagementSystem.Exceptions.VaccinationAddressNotFound;
import com.example.vaccineManagementSystem.Models.VaccinationCenter;
import com.example.vaccineManagementSystem.Repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VaccinationService {
    @Autowired
    private VaccinationRepository vaccinationRepository;
    public String addCenter(VaccinationCenter vaccinationCenter) throws VaccinationAddressNotFound {
        if(vaccinationCenter.getAddress() == null){
            throw new VaccinationAddressNotFound("Vaccination address is Empty!");
        }
        vaccinationRepository.save(vaccinationCenter);
        return "Vaccination cener added at a location :" + vaccinationCenter.getAddress();
    }
}
