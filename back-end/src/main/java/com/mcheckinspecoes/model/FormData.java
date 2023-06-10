package com.mcheckinspecoes.model;

import com.mcheckinspecoes.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormData {
    private MultipartFile image;
    private String itemName;
    private Status status;
    private String observations;
}
