package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.Enterprise;
import com.mcheckinspecoes.model.User;
import com.mcheckinspecoes.repository.EnterpriseRepository;
import com.mcheckinspecoes.repository.UserRepository;
import com.mcheckinspecoes.service.EnterpriseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    private final UserRepository userRepository;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository, UserRepository userRepository) {
        this.enterpriseRepository = enterpriseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Enterprise save(Enterprise enterprise, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            enterprise.setUser(user);
            user.setEnterprise(enterprise);
            return enterpriseRepository.save(enterprise);
        } else {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
    }

    @Override
    public Optional<Enterprise> findById(Long id) {
        return enterpriseRepository.findById(id);
    }

    @Override
    public List<Enterprise> findAll() {
        return enterpriseRepository.findAll();
    }

    @Override
    public Enterprise update(Long id, Enterprise updatedEnterprise) {
        Enterprise enterprise = enterpriseRepository.findById(id).orElse(null);
        if (enterprise != null) {
            enterprise.setEnterpriseName(updatedEnterprise.getEnterpriseName());
            enterprise.setInspectorName(updatedEnterprise.getInspectorName());
            enterprise.setInspectorPhone(updatedEnterprise.getInspectorPhone());
            enterprise.setInspectorEmail(updatedEnterprise.getInspectorEmail());
            return enterpriseRepository.save(enterprise);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
       enterpriseRepository.deleteById(id);
    }
}
