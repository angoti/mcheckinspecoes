package com.mcheckinspecoes.service;

import com.mcheckinspecoes.model.Enterprise;

import java.util.List;
import java.util.Optional;

public interface EnterpriseService {

    List<Enterprise> findAll();

    Optional<Enterprise> findById(Long id);

    Enterprise update(Long id, Enterprise enterprise);

    void delete(Long id);

    void save(Enterprise enterprise);

    boolean existsByEnterpriseName(String name);
}
