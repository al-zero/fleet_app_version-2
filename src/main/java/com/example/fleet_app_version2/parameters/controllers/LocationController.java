package com.example.fleet_app_version2.parameters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {


    @GetMapping("/locations")
    public String getLocations(){
        return "parameters/locations";
    }
}
