package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.Enterprise;
import com.mcheckinspecoes.repository.EnterpriseRepository;
import com.mcheckinspecoes.service.EnterpriseService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {


    private final EnterpriseRepository enterpriseRepository;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    public List<Enterprise> findAll() {
        return enterpriseRepository.findAll();
    }

    @Override
    public Optional<Enterprise> findById(Long id) {
        return enterpriseRepository.findById(id);
    }

    @Override
    public Enterprise update(Long id, Enterprise enterprise) {
        try {
            Optional<Enterprise> optionalEnterprise = enterpriseRepository.findById(id);
            if (optionalEnterprise.isPresent()) {
                Enterprise oldEnterprise = optionalEnterprise.get();
                oldEnterprise.setEnterpriseName(enterprise.getEnterpriseName());
                oldEnterprise.setInspectorEmail(enterprise.getInspectorEmail());
                oldEnterprise.setInspectorName(enterprise.getInspectorName());
                oldEnterprise.setInspectorPhone(enterprise.getInspectorPhone());
                return enterpriseRepository.save(oldEnterprise);
            } else {
                throw new IllegalArgumentException("Enterprise not found with ID: " + enterprise.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Enterprise enterprise = enterpriseRepository.findById(id).orElseThrow(NoSuchElementException::new);
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
