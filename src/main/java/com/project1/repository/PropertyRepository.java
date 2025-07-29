package com.project1.repository;

import com.project1.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
    PropertyEntity findByAddress(String address);
    PropertyEntity findByCity(String city);
    PropertyEntity findByState(String state);
    PropertyEntity findByZipCode(String zipCode);
    PropertyEntity findByCountry(String country);
    PropertyEntity findByPropertyType(String propertyType);
    boolean existsByAddress(String address);
    boolean existsByCity(String city);
    boolean existsByState(String state);
    boolean existsByZipCode(String zipCode);
    boolean existsByCountry(String country);
}
