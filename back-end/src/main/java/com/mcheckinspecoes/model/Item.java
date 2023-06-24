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
@Table(name = "TB_Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] itemImage;

    private String itemName;
    private Integer statusItem;
    private String observations;

    @ManyToOne
    @JsonBackReference(value="item-inspection")
    @JoinColumn(name = "inspection_id")
    private Inspection inspection;
}
