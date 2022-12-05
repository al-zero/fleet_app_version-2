package com.example.fleet_app_version2.parameters.services;

import com.example.fleet_app_version2.parameters.models.Contact;
import com.example.fleet_app_version2.parameters.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

         @Autowired
        private ContactRepository contactRepository;

         public List<Contact> getContacts(){
             return contactRepository.findAll();
         }
         public void save(Contact contact){
             contactRepository.save(contact);
         }
         public void delete(Integer id){
             contactRepository.deleteById(id);
         }

         public Contact getById(Integer id){
            return contactRepository.findById(id).orElse(null);
         }
}
