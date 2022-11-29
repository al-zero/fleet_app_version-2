package com.example.fleet_app_version2.parameters.controllers;

import com.example.fleet_app_version2.parameters.models.State;
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

    @GetMapping("/countries")
    public String getAll(Model model){
        List<State> StateList = stateService.getAllStates();
        model.addAttribute("countries", StateList );
        return "parameters/countries";
    }

    @GetMapping("/StateAdd")
    public String addState(){
        return "parameters/StateAdd";
    }

    @PostMapping("/countries")
    public  String saveState(State State){
            stateService.save(State);
            return  "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete/{id}", method =  {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        stateService.delete(id);
        return "redirect:/countries";
    }

    @GetMapping("/StateEdit/{id}")
    public String editState(@PathVariable Integer id,Model model){
        State state = stateService.getById(id);
        model.addAttribute("state", state);
        return "parameters/StateEdit";
    }

    @GetMapping("/StateDetails/{id}")
    public String StateDetails(@PathVariable Integer id,Model model){
        State State = stateService.getById(id);
        model.addAttribute("State", State);
        return "parameters/StateDetails";
    }

//
//    @RequestMapping(value = "/countries/update/{id}", method =  {RequestMethod.GET, RequestMethod.PUT})
//    public String update(State State){
//        StateService.save(State);
//        return "redirect:/countries";
//    }
}
