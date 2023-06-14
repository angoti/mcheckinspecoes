package com.mcheckinspecoes.model;
import com.mcheckinspecoes.model.enums.Status;
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
    private Status status;
    private String observations;
    @ManyToOne
    private Inspection inspection;
}
