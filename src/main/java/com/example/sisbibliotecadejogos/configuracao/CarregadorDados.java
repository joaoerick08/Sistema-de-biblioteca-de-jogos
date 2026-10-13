package com.example.sisbibliotecadejogos.configuracao;

import com.example.sisbibliotecadejogos.entidades.Categorias;
import com.example.sisbibliotecadejogos.entidades.Estudio;
import com.example.sisbibliotecadejogos.repositorios.CategoriaRepositorio;
import com.example.sisbibliotecadejogos.repositorios.EstudioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Cadastra alguns estudios e categorias de exemplo na primeira execucao,
 * para ja ser possivel criar jogos pelo front sem cadastrar nada antes.
 * So insere se a colecao estiver vazia (nao duplica a cada reinicio).
 */
@Component
@ConditionalOnProperty(name = "app.seed.enabled", havingValue = "true", matchIfMissing = true)
public class CarregadorDados implements CommandLineRunner {

    @Autowired
    private EstudioRepositorio estudioRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public void run(String... args) {
        if (estudioRepositorio.count() == 0) {
            estudioRepositorio.saveAll(List.of(
                    criarEstudio("FromSoftware", "Japão"),
                    criarEstudio("Nintendo", "Japão"),
                    criarEstudio("CD Projekt Red", "Polônia")
            ));
        }

        if (categoriaRepositorio.count() == 0) {
            categoriaRepositorio.saveAll(List.of(
                    criarCategoria("RPG"),
                    criarCategoria("Aventura"),
                    criarCategoria("Ação")
            ));
        }
    }

    private Estudio criarEstudio(String nome, String pais) {
        Estudio estudio = new Estudio();
        estudio.setNome(nome);
        estudio.setPais(pais);
        return estudio;
    }

    private Categorias criarCategoria(String nome) {
        Categorias categoria = new Categorias();
        categoria.setNome(nome);
        return categoria;
    }
}
