package com.fhb.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ErrorPageController {

    @GetMapping(path="/error")
    public String getPageNotFound(){return "error/PageNotFound";}
//
//    @GetMapping(path="/here")
//    public String getPageNotFo(){return "error/PageNotFound";}

}
