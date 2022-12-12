package com.example.fleet_app_version2.parameters.controllers;

import com.example.fleet_app_version2.parameters.models.Client;
import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.models.State;
import com.example.fleet_app_version2.parameters.services.ClientsService;
import com.example.fleet_app_version2.parameters.services.CountryService;
import com.example.fleet_app_version2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientsService clientsService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/clients")
    public String getClients(Model model){
        List<Client> clientList = clientsService.getClients();
        model.addAttribute("clients", clientList);
        return "parameters/clients";
    }

    @GetMapping("/clientAdd")
    public String addClient(Model model){
        List<Country> countryList = countryService.getAllCountries();
        List<State> stateList = stateService.getAllStates();

        model.addAttribute("states", stateList);
        model.addAttribute("countries", countryList);

        return "parameters/clientAdd";
    }
    @PostMapping("/clients")
    public String saveClient(Client client){
        clientsService.saveClient(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteClient(@PathVariable Integer id){
        clientsService.deleteClient(id);
        return "redirect:/clients";
    }

    @GetMapping("/client/edit/{id}")
    public String editClient(@PathVariable Integer id, Model model){
       // clientsService.editClient(id);
        State state = stateService.getById(id);
        Country countries = countryService.getById(id);
        Client client = clientsService.getByClientById(id);

        model.addAttribute("states", state);
        model.addAttribute("countries", countries);
        model.addAttribute("client", client);

        return "parameters/clientEdit";
    }

    @GetMapping("/client/details/{id}")
    public String detailsClient(@PathVariable Integer id, Model model){
        // clientsService.editClient(id);
        State state = stateService.getById(id);
        Country countries = countryService.getById(id);
        Client client = clientsService.getByClientById(id);

        model.addAttribute("states", state);
        model.addAttribute("countries", countries);
        model.addAttribute("client", client);

        return "parameters/clientDetails";
    }


}
