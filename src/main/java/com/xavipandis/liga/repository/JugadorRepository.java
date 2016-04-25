package com.xavipandis.liga.repository;

import com.xavipandis.liga.domain.Jugador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the Jugador entity.
 */
public interface JugadorRepository extends JpaRepository<Jugador,Long> {


    @Query("select jugador from Jugador jugador where jugador.canastasTotales >=:canastas")
    Page<Jugador> topPlayers(@Param("canastas") Integer canastas, Pageable pageable);


    //Lo ordeno en la directiva ng-repeat con un filtro y no aquí
    @Query("select jugador from Jugador jugador where jugador.asistenciasTotales >=:asistencias")
    Page<Jugador> topAsists(@Param("asistencias") Integer asistencias, Pageable pageable);
}
