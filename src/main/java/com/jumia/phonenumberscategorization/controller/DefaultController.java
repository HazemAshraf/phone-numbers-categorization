package com.jumia.phonenumberscategorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @GetMapping("/")
    public String root() {
        return "phone numbers categorization Back End";
    }
}
