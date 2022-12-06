package com.example.fleet_app_version2.parameters.controllers;

import com.example.fleet_app_version2.parameters.models.Contact;
import com.example.fleet_app_version2.parameters.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;


    @GetMapping("/contacts")
    public String getContacts(Model model){

        List<Contact> contactList = contactService.getContacts();
        model.addAttribute("contacts", contactList);

        return "parameters/contacts";
    }

    @GetMapping("/contact/add")
    public String addContact(){
        return "parameters/contactAdd";
    }

    @PostMapping("/contacts")
    public String saveContact(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value ="/contacts/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteContact(@PathVariable Integer id){
        contactService.delete(id);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/details/{id}")
    public String detailsContact(@PathVariable Integer id, Model model){
        Contact contact=  contactService.getById(id);
        model.addAttribute("contact", contact);
        return "parameters/contactDetails";
    }

    @GetMapping("/contacts/edit/{id}")
    public String editCountry(@PathVariable Integer id,Model model){
        Contact contact = contactService.getById(id);
        model.addAttribute("contact", contact);
        return "parameters/contactEdit";
    }
}
