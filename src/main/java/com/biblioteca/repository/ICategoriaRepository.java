package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

}
