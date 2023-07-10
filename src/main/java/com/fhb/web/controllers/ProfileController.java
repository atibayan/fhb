package com.fhb.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProfileController {


    @GetMapping("/register/profile")
    public String profileSetUp(){return "registration/UserProfile";}

    @PostMapping("/profile/save")
    public String saveProfile(Model model){

//        model.addAttribute();

        return "redirect:/";
    }

}
