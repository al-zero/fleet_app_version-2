package com.example.fleet_app_version2;

import com.example.fleet_app_version2.parameters.models.Country;
import com.example.fleet_app_version2.parameters.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryTest {

    @Autowired
    private CountryRepository countryRepository;

    // Find by Id
    @Test
    public void tesFindById(){
        Country country = countryRepository.findById(2).orElse(null);
        assertNotNull(country);
    }

    // Find by ID empty
    @Test
    public void emptyTesFindById(){
        Country country = countryRepository.findById(100).orElse(null);
        assertNotNull(country);
    }

}
