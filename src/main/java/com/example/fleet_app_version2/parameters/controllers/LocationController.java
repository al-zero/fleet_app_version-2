package com.example.fleet_app_version2.parameters.controllers;

import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.models.Location;
import com.example.fleet_app_version2.parameters.models.State;
import com.example.fleet_app_version2.parameters.repositories.LocationRepository;
import com.example.fleet_app_version2.parameters.services.CountryService;
import com.example.fleet_app_version2.parameters.services.LocationService;
import com.example.fleet_app_version2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
public class LocationController {


    @Autowired
    private LocationService locationService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @GetMapping("/locations")
    public String getLocations(Model model){

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        return "parameters/locations";
    }

    @GetMapping("/locationAdd")
    public String addLocation(Location location, Model model){
        List<Country> countryList = countryService.getAllCountries();
        List<State> statesList = stateService.getAllStates();

        model.addAttribute("countries", countryList);
        model.addAttribute("states", statesList);

        return "parameters/locationAdd";
    }

    @PostMapping("/locations")
    public String saveLocation(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/location/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String deleteLocation(@PathVariable Integer id){
        locationService.delete(id);
        return "redirect:/locations";
    }

    @GetMapping("/locations/edit/{id}")
    public String editLocation(@PathVariable Integer id,Model model){
        locationService.getById(id);
        return "parameter/locationEdit";
    }

    @GetMapping("/locations/details/{id}")
    public String detailsLocation(@PathVariable Integer id,Model model){
        return "parameter/locationDetails";
    }
}
