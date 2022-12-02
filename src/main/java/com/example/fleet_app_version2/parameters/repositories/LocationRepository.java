package com.example.fleet_app_version2.parameters.repositories;

import com.example.fleet_app_version2.parameters.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
