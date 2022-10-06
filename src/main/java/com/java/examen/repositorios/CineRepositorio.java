package com.java.examen.repositorios;

import com.java.examen.modelos.Cine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CineRepositorio extends JpaRepository<Cine,Integer> {

    @Query("select e from Cine as e where e.registro_activo = true")
    List<Cine> findAll();

}
