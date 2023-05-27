package com.mcheckinspecoes.model;

import com.mcheckinspecoes.model.Enterprise;
import com.mcheckinspecoes.model.Inspection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_Users")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<Inspection> inspecoesList = new ArrayList<>();
    @ManyToMany
    private List<Enterprise> enterpriseList = new ArrayList<>();
}
