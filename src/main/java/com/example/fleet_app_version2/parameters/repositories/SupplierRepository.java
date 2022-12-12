package com.example.fleet_app_version2.parameters.repositories;

import com.example.fleet_app_version2.parameters.models.Supplier;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository <Supplier, Integer> {
}
