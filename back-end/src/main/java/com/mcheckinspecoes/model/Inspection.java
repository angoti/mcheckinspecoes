package com.mcheckinspecoes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value="user-inspection")
    private User user;

    @OneToOne
    @JoinColumn(name = "enterprise_id")
    @JsonBackReference(value="inspection-enterprise")
    private Enterprise enterprise;


    private String inspectionName;
    private String inspectionLocation;
    private String coordinatesUtmM;
    private String coordinatesUtmE;
    private Date dateInspection = new Date();
    private String signature;

    @OneToMany(mappedBy = "inspection", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value="item-inspection")
    private List<Item> items = new ArrayList<>();

}
