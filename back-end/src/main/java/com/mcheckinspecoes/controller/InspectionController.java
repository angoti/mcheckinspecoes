package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.Email;
import com.mcheckinspecoes.model.Inspection;

import com.mcheckinspecoes.service.impl.EmailServiceImpl;
import com.mcheckinspecoes.service.impl.InspectionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inspections")
public class InspectionController {

    private final InspectionServiceImpl inspectionService;

    private final EmailServiceImpl emailService;

    public InspectionController(InspectionServiceImpl inspectionService, EmailServiceImpl emailService) {
        this.inspectionService = inspectionService;
        this.emailService = emailService;
    }


    @PostMapping("/{id}")
    public Inspection createInspection(@RequestBody Inspection inspection, @PathVariable Long id) {
        return inspectionService.save(inspection, id);
    }

    @GetMapping("/{id}")
    public Optional<Inspection> getInspectionById(@PathVariable Long id) {
        return inspectionService.findById(id);
    }

    @GetMapping
    public List<Inspection> getAllInspections() {
        return inspectionService.findAll();
    }

    @PutMapping("/{id}")
    public Inspection updateInspection(@PathVariable Long id, @RequestBody Inspection updatedInspection) {
        return inspectionService.update(id, updatedInspection);
    }

    @DeleteMapping("/{id}")
    public void deleteInspection(@PathVariable Long id) {
        inspectionService.delete(id);
    }


    @PostMapping("/send/email")
    public void sendNotification(@RequestBody Email email) {
        String to = email.getEmail();
        String subject = email.getSubject1();
        String body = email.getBody1();
        emailService.sendEmail(to, subject, body);
    }
}
