package com.example.baskabirornek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForgotPasswordController {

    @RequestMapping("/forgot_password")
    public String getForgotPassPage() {
        return "forgot_password";
    }
}
