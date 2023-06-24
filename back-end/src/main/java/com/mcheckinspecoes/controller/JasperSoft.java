package com.mcheckinspecoes.controller;

import net.sf.jasperreports.engine.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/generate")
public class JasperSoft {

    @GetMapping(value = "/pdf/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public void generatePDF(HttpServletResponse response, @PathVariable Integer id) throws JRException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inspections", "root", "password");

        // Carregar o arquivo .jrxml
        File jrxmlFile = new File("src/main/resources/templates/mcheck.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFile.getAbsolutePath());

        // Preencher os parâmetros do relatório, se houver
        Map<String, Object> params = new HashMap<>();
        params.put("INSPECTION_ID", id);

        // Preencher os dados do relatório
        // Exemplo usando um objeto de origem de dados vazio (sem dados)
        JRDataSource dataSource = new JREmptyDataSource();

        // Alternativamente, você pode usar um objeto de origem de dados preenchido com os dados do banco de dados
        // Exemplo usando uma lista de objetos (classe Bean) como fonte de dados
        // List<YourDataBean> dataList = getDataFromDatabase(connection);
        // JRDataSource dataSource = new JRBeanCollectionDataSource(dataList);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);

        // Fechar a conexão com o banco de dados
        connection.close();

        // Exportar para PDF ou outro formato
        String outputPath = "src/main/resources/templates/pdfFinalVersion.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath);

        System.out.println("Relatório gerado com sucesso!");
    }

}


