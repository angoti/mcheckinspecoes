package com.mcheckinspecoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_Inspections")
public class Inspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inspectionName;
    @OneToOne
    private Enterprise enterprise;
    private String inspectionLocation;
    private String coordinatesUtmM;
    private String coordinatesUtmE;
    private Date dateInspection = new Date();
    @OneToMany
    private List<Item> itemsList =  new ArrayList<>();
}
