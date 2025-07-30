package com.project1.repository;

import com.project1.entity.AgentEntity;
import com.project1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<AgentEntity, Long> {
    List<AgentEntity> findBySpecialization(String specialization);
    boolean existsByLicenseNumber(String licenseNumber);
    UserEntity findByLicenseNumber(String licenseNumber);
    UserEntity findByAgentId(Long agentId);
    boolean existsByUserId(UserEntity userId);

}
