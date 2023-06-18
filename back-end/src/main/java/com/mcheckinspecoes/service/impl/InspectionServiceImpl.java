package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.Inspection;
import com.mcheckinspecoes.model.User;
import com.mcheckinspecoes.repository.InspectionRepository;
import com.mcheckinspecoes.repository.UserRepository;
import com.mcheckinspecoes.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InspectionServiceImpl implements InspectionService {

    private final InspectionRepository inspectionRepository;

    private final UserRepository userRepository;

    @Autowired
    public InspectionServiceImpl(InspectionRepository inspectionRepository, UserRepository userRepository) {
        this.inspectionRepository = inspectionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Inspection save(Inspection inspection, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            inspection.setUser(user);
            inspection.setEnterprise(user.getEnterprise());
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }

        return inspectionRepository.save(inspection);
    }


    @Override
    public Optional<Inspection> findById(Long id) {
        return inspectionRepository.findById(id);
    }

    @Override
    public List<Inspection> findAll() {
        return inspectionRepository.findAll();
    }

    @Override
    public Inspection update(Long id, Inspection updatedInspection) {
        Inspection inspection = inspectionRepository.findById(id).orElse(null);
        if (inspection != null) {
            inspection.setInspectionName(updatedInspection.getInspectionName());
            inspection.setInspectionLocation(updatedInspection.getInspectionLocation());
            inspection.setCoordinatesUtmM(updatedInspection.getCoordinatesUtmM());
            inspection.setCoordinatesUtmE(updatedInspection.getCoordinatesUtmE());
            inspection.setDateInspection(updatedInspection.getDateInspection());
            return inspectionRepository.save(inspection);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        inspectionRepository.deleteById(id);
    }
}
