package com.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.model.Libro;

public interface ILibroRepository extends JpaRepository<Libro, Integer> {
    List<Libro> findByDisponibilidad(boolean disponibilidad);

}
