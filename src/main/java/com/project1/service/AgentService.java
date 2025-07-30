package com.project1.service;

import com.project1.entity.AgentEntity;
import com.project1.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public AgentEntity createAgent(AgentEntity agentEntity) {
        if(agentRepository.existsByLicenseNumber(agentEntity.getLicenseNumber())) {
            throw new IllegalArgumentException("License number already exists");
        }

        if(agentRepository.existsByUserId(agentEntity.getUserId())) {
            throw new IllegalArgumentException("User is already an agent");
        }

        return agentRepository.save(agentEntity);
    }

    public AgentEntity getAgentById(Long agentId) {
        return agentRepository.findById(agentId)
                .orElseThrow(() -> new IllegalArgumentException("Agent not found with id: " + agentId));
    }

    public AgentEntity updateAgent(Long agentId, AgentEntity updatedAgent) {
        AgentEntity existingAgent = getAgentById(agentId);
        existingAgent.setLicenseNumber(updatedAgent.getLicenseNumber());
        existingAgent.setAgencyName(updatedAgent.getAgencyName());
        return agentRepository.save(existingAgent);
    }

    public void deleteAgent(Long agentId) {
        AgentEntity existingAgent = getAgentById(agentId);
        agentRepository.delete(existingAgent);
    }

    public List<AgentEntity> getAllAgents() {
        return agentRepository.findAll();
    }
}
