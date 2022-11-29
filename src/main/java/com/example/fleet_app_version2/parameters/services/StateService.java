package com.example.fleet_app_version2.parameters.services;

import com.example.fleet_app_version2.parameters.models.State;
import com.example.fleet_app_version2.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

   public List<State> getAllStates(){
    return stateRepository.findAll();
}

    public void save(State state) {
        stateRepository.save(state);
    }

    public void delete(Integer id){
       stateRepository.deleteById(id);
    }

    public State getById(Integer id) {
       return stateRepository.findById(id).orElse(null);
    }
}
