package com.example.sisbibliotecadejogos.repositorios;

import com.example.sisbibliotecadejogos.entidades.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categorias, Long> {
}