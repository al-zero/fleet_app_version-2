package com.example.fleet_app_version2.parameters.controllers;

import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.models.State;
import com.example.fleet_app_version2.parameters.models.Supplier;
import com.example.fleet_app_version2.parameters.services.CountryService;
import com.example.fleet_app_version2.parameters.services.StateService;
import com.example.fleet_app_version2.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @GetMapping("/suppliers")
    public String getSuppliers(Model model){
        List<Supplier> supplierList = supplierService.getSuppliers();
        model.addAttribute("suppliers", supplierList);

        return "parameters/suppliers";
    }
    @GetMapping("/supplierAdd")
    public String addSupplier(Model model){

        List <Country> countryList = countryService.getAllCountries();
        List<State> stateList = stateService.getAllStates();

        model.addAttribute("countries", countryList);
        model.addAttribute("states", stateList);

        return "parameters/supplierAdd";
    }

    @PostMapping("suppliers")
    public String saveSupplier(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }
}
