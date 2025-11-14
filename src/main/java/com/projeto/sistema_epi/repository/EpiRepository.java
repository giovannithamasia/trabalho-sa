package com.projeto.sistema_epi.repository;

import com.projeto.sistema_epi.entity.EpiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpiRepository extends JpaRepository<EpiEntity,Integer> {
}
