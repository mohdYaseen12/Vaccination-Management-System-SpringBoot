package com.example.vaccineManagementSystem.Services;

import com.example.vaccineManagementSystem.Dtos.RequestDtos.AppointmentReqDto;
import com.example.vaccineManagementSystem.Exceptions.DoctorNotFound;
import com.example.vaccineManagementSystem.Exceptions.UserNotFound;
import com.example.vaccineManagementSystem.Models.Appointment;
import com.example.vaccineManagementSystem.Models.Doctor;
import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Repository.AppointmentRepository;
import com.example.vaccineManagementSystem.Repository.DoctorRepository;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AppointmentServices {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;
    public String bookAppointment(AppointmentReqDto appointmentReqDto) throws DoctorNotFound, UserNotFound {

        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentReqDto.getDocId());
        if(!optionalDoctor.isPresent()){
            throw new DoctorNotFound("DoctorId Not found");
        }

        Optional<User> optionalUser = userRepository.findById(appointmentReqDto.getUserId());

        if(!optionalUser.isPresent()){
            throw new UserNotFound("UserID not Found");
        }
        Doctor doctor = optionalDoctor.get();
        User user = optionalUser.get();

        Appointment appointment = new Appointment();

        // creating the object and seting its attribute.
        appointment.setAppointmentDate(appointmentReqDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentReqDto.getApppointmentTime());
        appointment.setDoctor(doctor);
        appointment.setUser(user);

        appointment = appointmentRepository.save(appointment);

        doctor.getAppointmentList().add(appointment);
        user.getAppointmentList().add(appointment);

        doctorRepository.save(doctor);
        userRepository.save(user);

        return "Appointment booked successfully";
    }
}
