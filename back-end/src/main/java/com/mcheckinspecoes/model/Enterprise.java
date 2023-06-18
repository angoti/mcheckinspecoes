package com.mcheckinspecoes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_Enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "enterprise", cascade = CascadeType.ALL)
    @JsonBackReference(value="user-enterprise")
    private User user;

    @OneToOne(mappedBy = "enterprise", cascade = CascadeType.ALL)
    @JsonBackReference(value="inspection-enterprise")
    private Inspection inspection;

    private String enterpriseName;
    private String inspectorName;
    private String inspectorPhone;
    private String inspectorEmail;
}
