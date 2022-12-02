package com.example.fleet_app_version2.parameters.controllers;

import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.models.State;
import com.example.fleet_app_version2.parameters.services.CountryService;
import com.example.fleet_app_version2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/states")
    public String getAll(Model model){
        List<State> StateList = stateService.getAllStates();
        model.addAttribute("states", StateList );
        return "parameters/states";
    }

    @GetMapping("/stateAdd")
    public String addState(Model model){

        List<Country> countryList = countryService.getAllCountries();
        model.addAttribute("countries", countryList );
        return "parameters/stateAdd";
    }

    @PostMapping("/states")
    public  String saveState(State State){
            stateService.save(State);
            return  "redirect:/states";
    }

    @RequestMapping(value = "/state/delete/{id}", method =  {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        stateService.delete(id);
        return "redirect:/states";
    }

    @GetMapping("/stateEdit/{id}")
    public String editState(@PathVariable Integer id,Model model){
        State state = stateService.getById(id);
        Country countries = countryService.getById(id);

        model.addAttribute("countries", countries);
        model.addAttribute("state", state);
        return "parameters/stateEdit";
    }

    @GetMapping("/stateDetails/{id}")
    public String StateDetails(@PathVariable Integer id,Model model){
        State state = stateService.getById(id);
        Country countries = countryService.getById(id);

        model.addAttribute("state", state);
        model.addAttribute("countries", countries);
        return "parameters/stateDetails";
    }

//
//    @RequestMapping(value = "/countries/update/{id}", method =  {RequestMethod.GET, RequestMethod.PUT})
//    public String update(State State){
//        StateService.save(State);
//        return "redirect:/countries";
//    }
}
