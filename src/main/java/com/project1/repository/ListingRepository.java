package com.project1.repository;

import com.project1.entity.ListingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<ListingEntity, Long> {
    public ListingEntity findByListingId(Long listingId);
    public ListingEntity findByProperty_PropertyId(Long propertyId);
    public ListingEntity findByAgent_AgentId(Long agentId);
    public ListingEntity findByStatus(String status);
    public ListingEntity findByPublishedDate(java.util.Date publishedDate);
    public ListingEntity findByExpirationDate(java.util.Date expirationDate);
}
