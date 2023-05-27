package com.mcheckinspecoes.mcheckinspecoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
