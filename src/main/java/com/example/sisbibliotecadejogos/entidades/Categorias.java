package com.example.sisbibliotecadejogos.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
@Getter
@Setter
@NoArgsConstructor
public class Categorias {

    @Id
    private String id;

    private String nome;
}
