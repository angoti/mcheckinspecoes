package com.mcheckinspecoes.mcheckinspecoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Inspections")
public class Inspection {
    @Id
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
