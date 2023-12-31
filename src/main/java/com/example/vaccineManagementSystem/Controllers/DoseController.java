package com.example.vaccineManagementSystem.Controllers;

import com.example.vaccineManagementSystem.Services.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    private DoseService doseService;

    @PostMapping("/givedose")
    public String giveDose(@RequestParam("doseId") Integer doseId, @RequestParam("userId") Integer userId){
        return doseService.giveDose(doseId,userId);
    }

}
