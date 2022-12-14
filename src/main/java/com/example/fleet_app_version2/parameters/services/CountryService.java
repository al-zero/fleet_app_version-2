package com.example.fleet_app_version2.parameters.services;

import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

   public List<Country> getAllCountries(){
    return countryRepository.findAll();
}

    public void save(Country country) {
        countryRepository.save(country);
    }

    public void delete(Integer id){
       countryRepository.deleteById(id);
    }

    public Country findById(Integer id) {
       return countryRepository.findById(id).orElse(null);
    }
}
