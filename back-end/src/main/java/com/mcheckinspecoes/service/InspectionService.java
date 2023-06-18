package com.mcheckinspecoes.service;

import com.mcheckinspecoes.model.Inspection;

import java.util.List;
import java.util.Optional;

public interface InspectionService {

    Inspection save(Inspection inspection, Long id);

    Optional<Inspection> findById(Long id);

    List<Inspection> findAll();

    Inspection update(Long id, Inspection inspection);

    void delete(Long id);

}
