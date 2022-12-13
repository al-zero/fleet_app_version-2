package com.example.fleet_app_version2.parameters.controllers;

import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.models.State;
import com.example.fleet_app_version2.parameters.models.Supplier;
import com.example.fleet_app_version2.parameters.services.CountryService;
import com.example.fleet_app_version2.parameters.services.StateService;
import com.example.fleet_app_version2.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/suppliers/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET })
    public String deleteSupplier(@PathVariable Integer id){
            supplierService.delete(id);
            return "redirect:/suppliers";
    }

    @GetMapping("/supplier/edit/{id}")
    public String editSupplier(@PathVariable Integer id, Model model){
       mySupplier(id,model);
        return "parameters/supplierEdit";
    }


    @GetMapping("/supplier/details/{id}")
    public String detailsSupplier(@PathVariable Integer id, Model model){
        mySupplier(id, model);
        return "parameters/supplierDetails";
    }

    public void mySupplier(@PathVariable Integer id, Model model){
        Supplier supplier = supplierService.findSupplierById(id);
        Country country = countryService.findById(id);
        State state = stateService.getById(id);

        model.addAttribute("states",state);
        model.addAttribute("supplier", supplier);
        model.addAttribute("countries", country);
    }
}
