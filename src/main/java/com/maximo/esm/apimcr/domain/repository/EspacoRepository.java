package com.maximo.esm.apimcr.domain.repository;

import com.maximo.esm.apimcr.domain.entity.Espaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacoRepository extends JpaRepository<Espaco,Integer> {
}
