package com.mcheckinspecoes.service;

import com.mcheckinspecoes.model.Inspection;

import java.util.List;
import java.util.Optional;

public interface InspectionService {

    List<Inspection> findAll();

    Optional<Inspection> findById(Long id);

    Inspection update(Long id, Inspection inspection);

    void delete(Long id);

    void save(Inspection inspection);

    boolean existsByInspectionName(String name);
}
