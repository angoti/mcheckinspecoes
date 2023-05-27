package com.mcheckinspecoes.mcheckinspecoes.repository;

import com.mcheckinspecoes.mcheckinspecoes.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository  extends JpaRepository<Enterprise, Long> {
}
