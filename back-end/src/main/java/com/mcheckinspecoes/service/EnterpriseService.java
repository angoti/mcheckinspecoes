package com.mcheckinspecoes.service;

import com.mcheckinspecoes.model.Enterprise;

import java.util.List;
import java.util.Optional;

public interface EnterpriseService {

    Enterprise save(Enterprise enterprise, Long id);

    Optional<Enterprise> findById(Long id);

    List<Enterprise> findAll();

    Enterprise update(Long id, Enterprise enterprise);

    void delete(Long id);

}
