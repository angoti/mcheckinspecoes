package com.mcheckinspecoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_Enterprises")
public class Enterprise {
    @Id
    private Long id;
    private String enterpriseName;
    private String inspectorName;
    private String inspectorPhone;
    private String inspectorEmail;
}
