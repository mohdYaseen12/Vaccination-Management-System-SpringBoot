package com.example.vaccineManagementSystem.Controllers;

import com.example.vaccineManagementSystem.Dtos.RequestDtos.AssociateDocDto;
import com.example.vaccineManagementSystem.Models.Doctor;
import com.example.vaccineManagementSystem.Services.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorServices doctorServices;

    @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor){
        try{
            String response = doctorServices.addDoctor(doctor);
            return response;
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("associateWithCenter")
    public ResponseEntity<String> associateDoctor(@RequestBody AssociateDocDto associateDocDto){
        try{
            String response = doctorServices.associateDoctor(associateDocDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
