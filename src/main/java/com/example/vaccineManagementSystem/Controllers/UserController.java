package com.example.vaccineManagementSystem.Controllers;

import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/getVaccinationDate")
    public Date getVaccinationDate(@RequestParam("userId") Integer userId){
        return userService.getVaccinationDate(userId);
    }

}
