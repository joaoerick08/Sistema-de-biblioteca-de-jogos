package com.example.sisbibliotecadejogos.repositorios;

import com.example.sisbibliotecadejogos.entidades.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepositorio extends JpaRepository<Estudio, Long> {

}