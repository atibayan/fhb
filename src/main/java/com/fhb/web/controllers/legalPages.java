package com.fhb.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class legalPages {
    @GetMapping(path="/legal/acceptable_use_policy")
    public String getAcceptableUsePolicy(){return "legalPages/AcceptableUsePolicy";}

    @GetMapping(path="/legal/contact_us")
    public String getContactPage(){return "legalPages/ContactUs";}

    @GetMapping(path="/legal/cookies_policy")
    public String getCookiesPolicy(){return "legalPages/CookiesPolicy";}

    @GetMapping(path="/legal/disclaimer")
    public String getDisclaimer(){return "legalPages/Disclaimer";}

    @GetMapping(path="/legal/insurance_policy")
    public String getInsurancePolicy(){return "legalPages/InsurancePolicy";}

    @GetMapping(path="/legal/terms_of_use_policy")
    public String getPrivacyPolicy(){return "legalPages/PrivacyPolicy";}

}