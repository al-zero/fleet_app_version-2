package com.example.fleet_app_version2.parameters.controllers;

import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getAll(Model model){
        List<Country> countryList = countryService.getAllCountries();
        model.addAttribute("countries", countryList );
        return "parameters/countries";
    }

    @GetMapping("/countryAdd")
    public String addCountry(){
        return "parameters/countryAdd";
    }

    @PostMapping("/countries")
    public  String saveCountry(Country country){
            countryService.save(country);
            return  "redirect:/countries";
    }
}
