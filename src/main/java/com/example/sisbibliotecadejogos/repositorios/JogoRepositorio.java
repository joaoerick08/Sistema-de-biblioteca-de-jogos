package com.example.sisbibliotecadejogos.repositorios;

import com.example.sisbibliotecadejogos.entidades.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepositorio extends JpaRepository<Jogo, Long> {
}