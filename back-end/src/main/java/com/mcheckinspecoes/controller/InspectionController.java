package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.Email;
import com.mcheckinspecoes.model.Inspection;

import com.mcheckinspecoes.service.InspectionService;
import com.mcheckinspecoes.service.impl.EmailServiceImpl;
import com.mcheckinspecoes.service.impl.InspectionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inspection")
public class InspectionController implements InspectionService {

    private final InspectionServiceImpl inspectionServiceImpl;

    private final EmailServiceImpl emailServiceImpl;

    public InspectionController(InspectionServiceImpl inspectionServiceImpl, EmailServiceImpl emailServiceImpl) {
        this.inspectionServiceImpl = inspectionServiceImpl;
        this.emailServiceImpl = emailServiceImpl;
    }

    @Override
    @GetMapping
    public List<Inspection> findAll() {
        return inspectionServiceImpl.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Inspection> findById(@PathVariable Long id) {
        return inspectionServiceImpl.findById(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public Inspection update(@PathVariable Long id, @RequestBody Inspection inspection) {
        return inspectionServiceImpl.update(id, inspection);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        inspectionServiceImpl.delete(id);
    }

    @Override
    @PostMapping
    public void save(@RequestBody Inspection inspection) {
        inspectionServiceImpl.save(inspection);
    }

    @Override
    @GetMapping("/name")
    public boolean existsByInspectionName(@RequestBody String name) {
        return inspectionServiceImpl.existsByInspectionName(name);
    }

    @PostMapping("/send/email")
    public void sendNotification(@RequestBody Email email) {
        String to = email.getEmail();
        String subject = email.getSubject1();
        String body = email.getBody1();

        emailServiceImpl.sendEmail(to, subject, body);
    }
}
