package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.Enterprise;
import com.mcheckinspecoes.service.EnterpriseService;
import com.mcheckinspecoes.service.impl.EnterpriseServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController implements EnterpriseService {

    private final EnterpriseServiceImpl enterpriseServiceImpl;

    public EnterpriseController(EnterpriseServiceImpl enterpriseServiceImpl) {
        this.enterpriseServiceImpl = enterpriseServiceImpl;
    }

    @Override
    @GetMapping
    public List<Enterprise> findAll() {
        return enterpriseServiceImpl.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Enterprise> findById(@PathVariable Long id) {
        return enterpriseServiceImpl.findById(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public Enterprise update(@PathVariable Long id, @RequestBody Enterprise enterprise) {
        return enterpriseServiceImpl.update(id, enterprise);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        enterpriseServiceImpl.delete(id);
    }

    @Override
    @PostMapping
    public void save(Enterprise enterprise) {
        enterpriseServiceImpl.save(enterprise);
    }

    @Override
    @GetMapping("/name")
    public boolean existsByEnterpriseName(@RequestBody String name) {
        return enterpriseServiceImpl.existsByEnterpriseName(name);
    }
}
