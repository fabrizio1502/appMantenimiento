package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.model.Editorial;

public interface IEditorialRepository extends JpaRepository<Editorial, Integer> {

}
