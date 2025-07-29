package com.project1.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "property")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String propertyType;
    private String description;
    private Double price;
    private String ownerName;
    private String ownerContact;
    private String status; // e.g., available, sold, under contract
    private String imageUrl; // URL to the property image
    private String bedrooms; // Number of bedrooms
    private String bathrooms;
    private String squareFeet;
    private Date createdAt;
    private Date updatedAt;
}
