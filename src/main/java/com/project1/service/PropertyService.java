package com.project1.service;


import com.project1.entity.PropertyEntity;
import com.project1.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public ResponseEntity<List<PropertyEntity>> getAllProperties() {
        try {
            List<PropertyEntity> properties = propertyRepository.findAll();
            return ResponseEntity.ok(properties);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    public PropertyEntity createProperty(PropertyEntity propertyEntity) {
        if (propertyRepository.existsByAddress(propertyEntity.getAddress())) {
            throw new IllegalArgumentException("Property with this address already exists");
        }
        return propertyRepository.save(propertyEntity);
    }

    public PropertyEntity getPropertyById(Long propertyId) {
        return propertyRepository.findById(propertyId)
                .orElseThrow(() -> new IllegalArgumentException("Property not found with id: " + propertyId));
    }

    public PropertyEntity updateProperty(Long propertyId, PropertyEntity updatedProperty) {
        PropertyEntity existingProperty = getPropertyById(propertyId);
        existingProperty.setAddress(updatedProperty.getAddress());
        existingProperty.setPrice(updatedProperty.getPrice());
        existingProperty.setDescription(updatedProperty.getDescription());
        existingProperty.setImageUrl(updatedProperty.getImageUrl());
        return propertyRepository.save(existingProperty);
    }

    public void deleteProperty(Long propertyId) {
        PropertyEntity existingProperty = getPropertyById(propertyId);
        propertyRepository.delete(existingProperty);
    }

    public boolean existsByAddress(String address) {
        return propertyRepository.existsByAddress(address);
    }
}
