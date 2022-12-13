package com.example.fleet_app_version2.parameters.api;

import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {


    @Autowired
    private CountryService countryService;

    @GetMapping("/api/countries")
    public List<Country> getAll(){
        List<Country> countries = countryService.getAllCountries();
        return countries;
    }
}
