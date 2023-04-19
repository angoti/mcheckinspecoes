package com.mcheck.inspection.model;


import java.io.InputStream;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;

public class RelatorioPdfGenerator {

    public static byte[] generatePdfFromTemplate(String templateName, Map<String, Object> parameters, List<?> data) throws Exception {
        ClassPathResource resource = new ClassPathResource(templateName);
        InputStream inputStream = resource.getInputStream();
        JasperCompileManager.compileReportToFile(inputStream.toString(), resource.getFile().getAbsolutePath());

        JRDataSource dataSource = data != null && !data.isEmpty() ? new JRBeanCollectionDataSource(data) : new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(resource.getFile().getAbsolutePath(), parameters, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}

