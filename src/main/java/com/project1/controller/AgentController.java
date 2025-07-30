package com.project1.controller;


import com.project1.entity.AgentEntity;
import com.project1.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping
    public ResponseEntity getAllAgents() {
        List<AgentEntity> agents = agentService.getAllAgents();
        return ResponseEntity.ok(agents);
    }

    @GetMapping("/{ageentId}")
    public ResponseEntity getAgentById(@PathVariable Long agentId) {
        AgentEntity agent = agentService.getAgentById(agentId);
        return ResponseEntity.ok(agent);
    }

    /*
    @GetMapping("/user/{userId}")
    public ResponseEntity getAgentByUserId(@PathVariable Long userId) {
        AgentEntity agent = agentService.getAgentByUserId(userId);
        if (agent != null) {
            return ResponseEntity.ok(agent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    */

    @PostMapping
    public ResponseEntity createAgent(AgentEntity agentEntity) {
        try {
            AgentEntity createdAgent = agentService.createAgent(agentEntity);
            return ResponseEntity.status(201).body(createdAgent);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{agentId}")
    public ResponseEntity updateAgent(@PathVariable Long agentId, @RequestBody AgentEntity updatedAgent) {
        AgentEntity existingAgent = agentService.getAgentById(agentId);
        if (existingAgent == null) {
            return ResponseEntity.notFound().build();
        }
        AgentEntity updated = agentService.updateAgent(agentId, updatedAgent);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{agentId}")
    public ResponseEntity deleteAgent(@PathVariable Long agentId) {
        AgentEntity existingAgent = agentService.getAgentById(agentId);
        if (existingAgent == null) {
            return ResponseEntity.notFound().build();
        }
        agentService.deleteAgent(agentId);
        return ResponseEntity.noContent().build();
    }

}
