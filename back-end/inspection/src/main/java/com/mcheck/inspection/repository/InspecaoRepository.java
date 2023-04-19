package com.mcheck.inspection.repository;

import com.mcheck.inspection.model.Inspecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspecaoRepository extends JpaRepository<Inspecao, Long> {
}
