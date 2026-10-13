package com.example.sisbibliotecadejogos.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudios")
@Getter
@Setter
@NoArgsConstructor
public class Estudio {

    @Id
    private String id;

    private String nome;

    private String pais;
}
