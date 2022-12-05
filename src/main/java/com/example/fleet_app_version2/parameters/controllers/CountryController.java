package com.example.fleet_app_version2.parameters.controllers;

import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/countries/delete/{id}", method =  {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/countries";
    }

    @GetMapping("/countryEdit/{id}")
    public String editCountry(@PathVariable Integer id,Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "parameters/countryEdit";
    }

    @GetMapping("/countryDetails/{id}")
    public String countryDetails(@PathVariable Integer id,Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "parameters/countryDetails";
    }
    
    // Get country by id and return it as json
    @GetMapping("/country/{id}")
    @ResponseBody
    public  Country getCountry(@PathVariable Integer id){
        return countryService.getById(id);
    }



//
//    @RequestMapping(value = "/countries/update/{id}", method =  {RequestMethod.GET, RequestMethod.PUT})
//    public String update(Country country){
//        countryService.save(country);
//        return "redirect:/countries";
//    }
}
