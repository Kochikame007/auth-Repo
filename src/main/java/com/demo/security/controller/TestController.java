package com.demo.security.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @PostMapping("/login")
    public String login() {


        return "login successfully";
    }
}
