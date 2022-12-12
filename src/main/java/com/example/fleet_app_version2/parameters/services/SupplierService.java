package com.example.fleet_app_version2.parameters.services;

import com.example.fleet_app_version2.parameters.models.Supplier;
import com.example.fleet_app_version2.parameters.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }
    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }
    public void delete(Integer id){
        supplierRepository.deleteById(id);
    }
    public Supplier findSupplierById(Integer id){
        return supplierRepository.findById(id).orElse(null);
    }

}
