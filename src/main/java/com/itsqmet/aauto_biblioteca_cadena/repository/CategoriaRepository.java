package com.itsqmet.aauto_biblioteca_cadena.repository;

import com.itsqmet.aauto_biblioteca_cadena.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
}
