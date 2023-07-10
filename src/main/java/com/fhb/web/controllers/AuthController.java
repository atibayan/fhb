package com.fhb.web.controllers;

import com.fhb.web.Encryption.Encryption;
import com.fhb.web.dtos.RegistrationDto;
import com.fhb.web.models.User;
import com.fhb.web.repositories.UserRepository;
import com.fhb.web.services.UserService;
import com.fhb.web.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.apache.catalina.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AuthController {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "registration/LogIn";
    }

    @GetMapping("/")
    public String indexPage(Model model ) {
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();

        LOGGER.info("inside authcontroller userName: "+userName);

        if(!userName.equals("anonymousUser")){
            LOGGER.info("inside authcontroller userName: "+userName);

            long id=userService.findByUserName(userName).getUserId();

            model.addAttribute("name",userName);
            model.addAttribute("id",id);
        }

        return "LandingPage";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "registration/Register";
    }

    @PostMapping("/register/save")
    public String register(
            @Valid @ModelAttribute("user") RegistrationDto user, BindingResult result, Model model) {

        User existingUserEmail = userService.findByEmail(user.getEmail());

        // encrypt the user id and send it to the form.
//        Encryption enc= new Encryption();

//        model.addAttribute("newRegId",( existingUserEmail.getUserId()) );
//        model.addAttribute("userName",existingUserEmail.getUserName() );
        //        https://www.baeldung.com/spring-redirect-and-forward


        if(existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
            return "redirect:/register?fail";
        }

        User existingUserUsername = userService.findByUserName(user.getUserName());
        if(existingUserUsername != null && existingUserUsername.getUserName() != null && !existingUserUsername.getUserName().isEmpty()) {
            return "redirect:/register?fail";
        }

        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "registration/Register";
        }

        userService.save(user);

        return "registration/UserProfile";



    }




}
