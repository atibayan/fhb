package com.fhb.web.controllers;

import com.fhb.web.Encryption.Encryption;
import com.fhb.web.dtos.RegistrationDto;
import com.fhb.web.models.User;
import com.fhb.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "registration/LogIn";
    }

    @GetMapping("/")
    public String indexPage() {
        return "LandingPage";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "registration/Register";
    }

    @PostMapping("/register/save")
    public String register( @ModelAttribute("user") RegistrationDto user, BindingResult result, Model model) {

        User existingUserEmail = userService.findByEmail(user.getEmail());

        // encrypt the user id and send it to the form.
        Encryption enc= new Encryption();

        model.addAttribute("newRegId",enc.encrypt( existingUserEmail.getUserId()) );
        model.addAttribute("userName",existingUserEmail.getUserName() );
        //        https://www.baeldung.com/spring-redirect-and-forward

        return "registration/UserProfile";

        // while developing the website i dont want to have to eneter details in to the user form every time
            // need a quick fail

//
//
//        if(existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
//            return "redirect:/register?fail";
//        }
//
//        User existingUserUsername = userService.findByUserName(user.getUserName());
//        if(existingUserUsername != null && existingUserUsername.getUserName() != null && !existingUserUsername.getUserName().isEmpty()) {
//            return "redirect:/register?fail";
//        }
//
//        if(result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "registration/Register";
//        }
//
//        userService.save(user);
//
//


    }




}
