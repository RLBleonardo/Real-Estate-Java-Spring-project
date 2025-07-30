package com.project1.service;


import com.project1.entity.ListingEntity;
import com.project1.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    public ListingEntity createListing(ListingEntity listingEntity) {
        return listingRepository.save(listingEntity);
    }

    public List<ListingEntity> getAllListings() {
        return listingRepository.findAll();
    }

    public ListingEntity getListingById(Long listingId) {
        return listingRepository.findByListingId(listingId);
    }

    public ListingEntity updateListing(Long listingId, ListingEntity updatedListing) {
        ListingEntity existingListing = getListingById(listingId);
        existingListing.setProperty(updatedListing.getProperty());
        existingListing.setAgent(updatedListing.getAgent());
        existingListing.setStatus(updatedListing.getStatus());
        existingListing.setPublishedDate(updatedListing.getPublishedDate());
        existingListing.setExpirationDate(updatedListing.getExpirationDate());
        return listingRepository.save(existingListing);
    }

    public void deleteListing(Long listingId) {
        ListingEntity existingListing = getListingById(listingId);
        listingRepository.delete(existingListing);
    }

    public ListingEntity getListingsByAgentId(Long agentId) {
        return listingRepository.findByAgent_AgentId(agentId);
    }
    public ListingEntity getListingsByPropertyId(Long propertyId) {
        return listingRepository.findByProperty_PropertyId(propertyId);
    }
}
