package com.project1.controller;

import com.project1.entity.ListingEntity;
import com.project1.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping
    public ResponseEntity<List<ListingEntity>> getAllListings() {
        List<ListingEntity> listings = listingService.getAllListings();
        return ResponseEntity.ok(listings);
    }

    @GetMapping("/{listingId}")
    public ResponseEntity<ListingEntity> getListingById(@PathVariable Long listingId)
    {
        ListingEntity listing = listingService.getListingById(listingId);
        if (listing != null) {
            return ResponseEntity.ok(listing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/agent/{agentId}")
    public ResponseEntity<List<ListingEntity>> getListingsByAgentId(@PathVariable Long agentId) {
        List<ListingEntity> listings = Collections.singletonList(listingService.getListingsByAgentId(agentId));
        return ResponseEntity.ok(listings);

    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<ListingEntity>> getListingsByPropertyId(@PathVariable Long propertyId) {
        List<ListingEntity> listings = Collections.singletonList(listingService.getListingsByPropertyId(propertyId));
        return ResponseEntity.ok(listings);
    }

    @PostMapping
    public ResponseEntity<ListingEntity> createListing(@RequestBody ListingEntity listingEntity) {
        if (listingEntity.getProperty() == null || listingEntity.getAgent() == null) {
            return ResponseEntity.badRequest().build();
        }
        ListingEntity createdListing = listingService.createListing(listingEntity);
        return ResponseEntity.status(201).body(createdListing);
    }

    @PutMapping("/{listingId}")
    public ResponseEntity<ListingEntity> updateListing(@PathVariable Long listingId, @RequestBody ListingEntity updatedListing) {
        if (updatedListing.getProperty() == null || updatedListing.getAgent() == null) {
            return ResponseEntity.badRequest().build();
        }
        ListingEntity existingListing = listingService.getListingById(listingId);
        if (existingListing == null) {
            return ResponseEntity.notFound().build();
        }
        ListingEntity updated = listingService.updateListing(listingId, updatedListing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{listingId}")
    public ResponseEntity<ListingEntity> deleteListing(@PathVariable ListingEntity listingId) {
        if(listingService.getListingById(listingId.getListingId()) == null) {
            ResponseEntity.notFound().build();
        } else {
            listingService.deleteListing(listingId.getListingId());
        }
        return ResponseEntity.noContent().build();
    }

}
