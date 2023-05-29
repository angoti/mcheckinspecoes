package com.mcheckinspecoes.service;

import com.mcheckinspecoes.model.Enterprise;

import java.util.List;
import java.util.Optional;

public interface EnterpriseService {

    List<Enterprise> findAll();

    Optional<Enterprise> findById(Long id);

    void delete(Enterprise enterprise);

    void save(Enterprise enterprise);

    boolean existsByEnterpriseName(String name);
}
