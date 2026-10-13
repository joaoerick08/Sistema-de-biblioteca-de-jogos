package com.example.sisbibliotecadejogos.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "jogos")
@Getter
@Setter
@NoArgsConstructor
public class Jogo {

    @Id
    private String id;

    private String nome;
    private Integer anoLancamento;
    private Double pontuacao;
    private String avaliacaoPessoal;
    private String corLombada;

    @DBRef
    private Estudio estudio;

    @DBRef
    private List<Categorias> categorias;
}
