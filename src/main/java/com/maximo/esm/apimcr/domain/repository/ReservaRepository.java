package com.maximo.esm.apimcr.domain.repository;

import com.maximo.esm.apimcr.domain.entity.Reserva;
import com.maximo.esm.apimcr.domain.enums.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {


}
