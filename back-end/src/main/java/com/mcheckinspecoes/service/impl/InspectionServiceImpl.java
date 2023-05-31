package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.Inspection;
import com.mcheckinspecoes.repository.InspectionRepository;
import com.mcheckinspecoes.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InspectionServiceImpl implements InspectionService {

    @Autowired
    InspectionRepository inspectionRepository;

    @Override
    public List<Inspection> findAll() {
        return inspectionRepository.findAll();
    }

    @Override
    public Optional<Inspection> findById(Long id) {
        return inspectionRepository.findById(id);
    }

    @Override
    public Inspection update(Inspection inspection) {
        try {
            Inspection oldInspection = inspectionRepository.findById(inspection.getId()).get();
            oldInspection.setDateInspection(inspection.getDateInspection());
            oldInspection.setInspectionLocation(inspection.getInspectionLocation());
            oldInspection.setInspectionName(inspection.getInspectionName());
            oldInspection.setEnterprise(inspection.getEnterprise());
            oldInspection.setCoordinatesUtmE(inspection.getCoordinatesUtmE());
            oldInspection.setCoordinatesUtmM(inspection.getCoordinatesUtmM());
            inspectionRepository.save(oldInspection);
            return oldInspection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Inspection inspection) {
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
