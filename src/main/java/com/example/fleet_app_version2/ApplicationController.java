package com.example.fleet_app_version2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/index2")
    public String widget(){
        return "index2";
    }
}
