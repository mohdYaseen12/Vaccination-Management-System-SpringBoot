package com.example.vaccineManagementSystem.Services;

import com.example.vaccineManagementSystem.Dtos.RequestDtos.AssociateDocDto;
import com.example.vaccineManagementSystem.Exceptions.CenterNotFound;
import com.example.vaccineManagementSystem.Exceptions.DoctorAlreadyExistsException;
import com.example.vaccineManagementSystem.Exceptions.DoctorNotFound;
import com.example.vaccineManagementSystem.Exceptions.EmailIdEmptyException;
import com.example.vaccineManagementSystem.Models.Doctor;
import com.example.vaccineManagementSystem.Models.VaccinationCenter;
import com.example.vaccineManagementSystem.Repository.DoctorRepository;
import com.example.vaccineManagementSystem.Repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServices {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationRepository vaccinationRepository;
    public String addDoctor(Doctor doctor) throws EmailIdEmptyException, DoctorAlreadyExistsException {
        if(doctor.getEmailId() == null){
            throw new EmailIdEmptyException("Email id is mandatory");
        }
        if(doctorRepository.findByEmailId(doctor.getEmailId()) != null){
            throw new DoctorAlreadyExistsException("Doctor with the given email id already Exists");
        }

        doctorRepository.save(doctor);

        return "Doctor has been added to database";

    }

    public String associateDoctor(AssociateDocDto associateDocDto) throws DoctorNotFound, CenterNotFound {
        Integer docId = associateDocDto.getDocId();
        Optional<Doctor> doctorOptional = doctorRepository.findById(docId);
        if(!doctorOptional.isPresent()){
            throw new DoctorNotFound("Doctor id is Wrong!");
        }

        Integer centerId = associateDocDto.getCenterId();
        Optional<VaccinationCenter> optionalCenter = vaccinationRepository.findById(centerId);

        if(!optionalCenter.isPresent()){
            throw new CenterNotFound("Center Id entered is incorrect");
        }

        Doctor doctor = doctorOptional.get();

        VaccinationCenter vaccinationCenter = optionalCenter.get();

        doctor.setVaccinationCenter(vaccinationCenter); // setting the foreign key

        //setting bidirectional map
        //adding doctor to the list of doctors of that vaccination center
        vaccinationCenter.getDoctorList().add(doctor);

        vaccinationRepository.save(vaccinationCenter);

        return "Doctor has been associated to center";

    }
}
