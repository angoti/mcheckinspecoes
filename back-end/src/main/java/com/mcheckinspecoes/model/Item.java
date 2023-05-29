package com.mcheckinspecoes.model;

import com.mcheckinspecoes.mcheckinspecoes.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_Items")
public class Item {
    @Id
    private Long id;
    private byte[] itemImage;
    private String itemName;
    private Status status = Status.DEFAULT;
    private String observations;
}
