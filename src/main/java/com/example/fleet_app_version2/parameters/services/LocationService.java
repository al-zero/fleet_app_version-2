package com.example.fleet_app_version2.parameters.services;

import com.example.fleet_app_version2.parameters.models.Location;
import com.example.fleet_app_version2.parameters.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;


    public List<Location> getLocations(){
        return locationRepository.findAll();
    }
}
