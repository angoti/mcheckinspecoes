package com.mcheck.inspection.controller;

import com.mcheck.inspection.model.RelatorioPdfGenerator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PdfController {

    @GetMapping("/gerarRelatorio")
    public ResponseEntity<?> gerarRelatorio() {
        List<Object> dados = Collections.singletonList(""); // buscar dados do banco de dados ou outra fonte de dados
        String template = "caminho/para/o/template.jrxml";
        Map<String, Object> parametros = new HashMap<>();
        // adicionar parâmetros do relatório, se houver
        try {
            byte[] pdf = RelatorioPdfGenerator.generatePdfFromTemplate(template, parametros, dados);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "relatorio.pdf");
            headers.setContentLength(pdf.length);
            return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}