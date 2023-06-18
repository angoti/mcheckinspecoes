package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.Inspection;
import com.mcheckinspecoes.model.Item;
import com.mcheckinspecoes.model.enums.Status;
import com.mcheckinspecoes.service.impl.InspectionServiceImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    private final InspectionServiceImpl inspectionService;

    public PdfController(InspectionServiceImpl inspectionService) {
        this.inspectionService = inspectionService;
    }

    @GetMapping(value = "/inspection/{inspectionId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@PathVariable Long inspectionId) throws IOException {

        Optional<Inspection> optionalInspection = inspectionService.findById(inspectionId);

        if (optionalInspection.isPresent()) {
            Inspection inspection = optionalInspection.get();

            List<String> lines = mountPdfHeader(inspection);
            List<String> item = formatItemData(inspection.getItems());

            // Cria um novo documento PDF
            PDDocument document = new PDDocument();

            // Cria uma nova página
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Adiciona algum conteúdo à página
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Define a cor da borda (no exemplo, cor preta)
            contentStream.setStrokingColor(Color.BLACK);

            // Define a largura da borda (no exemplo, largura 1)
            contentStream.setLineWidth(2);

            // Posição inicial do retângulo
            float startX = 20;
            float startY = 820;

            // Tamanho do retângulo
            float width = 555;
            float height = 300;

            // Desenha a borda do retângulo
            contentStream.moveTo(startX, startY);
            contentStream.lineTo(startX + width, startY);
            contentStream.lineTo(startX + width, startY - height);
            contentStream.lineTo(startX, startY - height);
            contentStream.lineTo(startX, startY);

            // Fecha o caminho
            contentStream.closePath();

            // Pinta a borda
            contentStream.stroke();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.newLineAtOffset(startX + 5, startY - 15);

            for (String line : lines) {
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -24); // Espaçamento de linha de 12 pontos
            }

            for(Item item: inspection.getItems()){
                contentStream.showText(formatItemData(item).toString());
                contentStream.newLineAtOffset(0, -24);
            }

            contentStream.endText();
            contentStream.close();

            // Salva o documento em um ByteArrayOutputStream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            document.close();

            // Configura os cabeçalhos da resposta
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "example.pdf");

            // Retorna a resposta com o conteúdo do PDF
            return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();
    }

    private List<String> mountPdfHeader(Inspection inspection) {

        List<String> lines = new ArrayList<>();

        int compliant = 0;

        int not_compliant = 0;

        for (Item items : inspection.getItems()
        ) {
            if (items.getStatus().equals(Status.COMPLIANT)) {
                compliant++;
            } else {
                not_compliant++;
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(inspection.getDateInspection());

        lines.add(inspection.getInspectionName());
        lines.add("Empresa: " + inspection.getEnterprise().getEnterpriseName());
        lines.add("Inspetor: " + inspection.getUser().getUsername());
        lines.add("Telefone: " + inspection.getEnterprise().getInspectorPhone());
        lines.add("Email: " + inspection.getUser().getEmail());
        lines.add("ID da inspeção: " + inspection.getId());

        lines.add("Local da Inspeção: " + inspection.getInspectionLocation());
        lines.add("Coordenadas UTM (N): " + inspection.getCoordinatesUtmM());
        lines.add("Data da Inspeção: " + formattedDate);
        lines.add("Itens Conformes: " + compliant);
        lines.add("Coordenadas UTM (E): " + inspection.getCoordinatesUtmE());
        lines.add("Itens Não Conformes: " + not_compliant);

        return lines;

    }

    private List<String> formatItemData(List<Item> item) {
        List<String> itemData = new ArrayList<>();

        // Adiciona a imagem do item
        itemData.add(""+item.getItemImage());

        // Adiciona os demais dados do item
        itemData.add("Item inspecionado: " + item.getItemName());
        itemData.add("Status: " + item.getStatus());
        itemData.add("Comentários: " + item.getObservations());

        return itemData;
    }


}
