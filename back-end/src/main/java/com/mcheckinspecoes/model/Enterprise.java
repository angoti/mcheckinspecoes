package com.mcheckinspecoes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

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

    @OneToOne(mappedBy = "enterprise")
    @JsonBackReference(value="user-enterprise")
    @ToString.Exclude
    private User user;

    @OneToOne(mappedBy = "enterprise")
    @JsonBackReference(value="inspection-enterprise")
    @ToString.Exclude
    private Inspection inspection;

    private String enterpriseName;
    private String inspectorName;
    private String inspectorPhone;
    private String inspectorEmail;

}
