package com.example.sisbibliotecadejogos.controladores;

import com.example.sisbibliotecadejogos.entidades.Jogo;
import com.example.sisbibliotecadejogos.servicos.JogoServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoControlador {

    @Autowired
    private JogoServicos jogoServicos;

    @GetMapping
    public List<Jogo> listarTodos() {
        return jogoServicos.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorId(@PathVariable Long id) {
        return jogoServicos.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Jogo> salvar(@RequestBody Jogo jogo) {
        Jogo novoJogo = jogoServicos.salvar(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoJogo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(@PathVariable Long id, @RequestBody Jogo jogo) {
        try {
            Jogo jogoAtualizado = jogoServicos.atualizar(id, jogo);
            return ResponseEntity.ok(jogoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        jogoServicos.deletar(id);
        return ResponseEntity.noContent().build();
    }
}