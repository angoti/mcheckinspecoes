package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.Enterprise;
import com.mcheckinspecoes.service.impl.EnterpriseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

    private final EnterpriseServiceImpl enterpriseService;

    @Autowired
    public EnterpriseController(EnterpriseServiceImpl enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping("/{id}")
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise, @PathVariable Long id) {
        return enterpriseService.save(enterprise, id);
    }

    @GetMapping("/{id}")
    public Optional<Enterprise> getEnterpriseById(@PathVariable Long id) {
        return enterpriseService.findById(id);
    }

    @GetMapping
    public List<Enterprise> getAllEnterprises() {
        return enterpriseService.findAll();
    }

    @PutMapping("/{id}")
    public Enterprise updateEnterprise(@PathVariable Long id, @RequestBody Enterprise updatedEnterprise) {
        return enterpriseService.update(id, updatedEnterprise);
    }

    @DeleteMapping("/{id}")
    public void deleteEnterprise(@PathVariable Long id) {
        enterpriseService.delete(id);
    }
}

