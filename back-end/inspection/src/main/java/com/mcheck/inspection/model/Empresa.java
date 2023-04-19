package com.mcheck.inspection.model;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Empresa {
    @Id
    private Long id;

}
