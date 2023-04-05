package com.example.consumer.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping(path = "/",produces = MediaType.ALL_VALUE)
    public String ping(){
        return "consumer up and Running";
    }
}
