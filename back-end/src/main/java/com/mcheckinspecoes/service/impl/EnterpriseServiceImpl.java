package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.Enterprise;
import com.mcheckinspecoes.repository.EnterpriseRepository;
import com.mcheckinspecoes.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @Override
    public List<Enterprise> findAll() {
        return enterpriseRepository.findAll();
    }

    @Override
    public Optional<Enterprise> findById(Long id) {
        return enterpriseRepository.findById(id);
    }

    @Override
    public void delete(Enterprise enterprise) {
        enterpriseRepository.delete(enterprise);
    }

    @Override
    public void save(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

    @Override
    public boolean existsByEnterpriseName(String name) {
        return enterpriseRepository.existsByEnterpriseName(name);
    }
}
