package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.Inspection;
import com.mcheckinspecoes.repository.InspectionRepository;
import com.mcheckinspecoes.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InspectionServiceImpl implements InspectionService {

    private final InspectionRepository inspectionRepository;

    @Autowired
    public InspectionServiceImpl(InspectionRepository inspectionRepository) {
        this.inspectionRepository = inspectionRepository;
    }

    @Override
    public List<Inspection> findAll() {
        return inspectionRepository.findAll();
    }

    @Override
    public Optional<Inspection> findById(Long id) {
        return inspectionRepository.findById(id);
    }

    @Override
    public Inspection update(Long id, Inspection inspection) {
        try {
            Optional<Inspection> optionalInspection = inspectionRepository.findById(id);
            if (optionalInspection.isPresent()) {
                Inspection oldInspection = optionalInspection.get();
                oldInspection.setDateInspection(inspection.getDateInspection());
                oldInspection.setInspectionLocation(inspection.getInspectionLocation());
                oldInspection.setInspectionName(inspection.getInspectionName());
                oldInspection.setEnterprise(inspection.getEnterprise());
                oldInspection.setCoordinatesUtmE(inspection.getCoordinatesUtmE());
                oldInspection.setCoordinatesUtmM(inspection.getCoordinatesUtmM());
                return inspectionRepository.save(oldInspection);
            } else {
                throw new IllegalArgumentException("Inspection not found with ID: " + inspection.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Inspection inspection = inspectionRepository.findById(id).orElseThrow(NoSuchElementException::new);
        inspectionRepository.delete(inspection);
    }

    @Override
    public void save(Inspection inspection) {
        inspectionRepository.save(inspection);
    }

    @Override
    public boolean existsByInspectionName(String name) {
        return inspectionRepository.existsByInspectionName(name);
    }
}
