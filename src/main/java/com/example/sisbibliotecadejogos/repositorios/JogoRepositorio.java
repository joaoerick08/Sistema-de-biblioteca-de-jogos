package com.example.sisbibliotecadejogos.repositorios;

import com.example.sisbibliotecadejogos.entidades.Jogo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepositorio extends MongoRepository<Jogo, String> {
}
