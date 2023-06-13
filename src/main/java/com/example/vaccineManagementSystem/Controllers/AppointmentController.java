package com.example.vaccineManagementSystem.Controllers;

import com.example.vaccineManagementSystem.Dtos.RequestDtos.AppointmentReqDto;
import com.example.vaccineManagementSystem.Services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentServices appointmentServices;

    @PostMapping("/add")
    public String bookAppointment(@RequestBody AppointmentReqDto appointmentReqDto){
        try{
           String response = appointmentServices.bookAppointment(appointmentReqDto);
           return response;
        }
        catch (Exception e){
            return e.getMessage();
        }

    }
}
