package com.project1.controller;

import com.project1.entity.PropertyEntity;
import com.project1.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public ResponseEntity getAllProperties() {
        try {
            return ResponseEntity.ok(propertyService.getAllProperties());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving properties: " + e.getMessage());
        }
    }

    @GetMapping("/exists")
    public ResponseEntity checkPropertyExists(String address) {
        try {
            boolean exists = propertyService.existsByAddress(address);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error checking property existence: " + e.getMessage());
        }
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity getPropertyById(Long propertyId) {
        try {
            return ResponseEntity.ok(propertyService.getPropertyById(propertyId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Property not found with id: " + propertyId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving property: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createProperty(PropertyEntity propertyEntity) {
        try {
            PropertyEntity createdProperty = propertyService.createProperty(propertyEntity);
            return ResponseEntity.status(201).body(createdProperty);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error creating property: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating property: " + e.getMessage());
        }
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity updateProperty(Long propertyId, PropertyEntity updatedProperty) {
        try {
            PropertyEntity updated = propertyService.updateProperty(propertyId, updatedProperty);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Property not found with id: " + propertyId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating property: " + e.getMessage());
        }
    }

    @DeleteMapping("/{propertyId}")
    public ResponseEntity deleteProperty(Long propertyId) {
        try {
            propertyService.deleteProperty(propertyId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Property not found with id: " + propertyId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting property: " + e.getMessage());
        }
    }
}
