package com.example.fleet_app_version2.parameters.repositories;


import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
