package com.example.sisbibliotecadejogos.controladores;

import com.example.sisbibliotecadejogos.entidades.Categorias;
import com.example.sisbibliotecadejogos.servicos.CategoriaServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasControlador {

    @Autowired
    private CategoriaServicos categoriaServicos;

    @GetMapping
    public List<Categorias> listarTodos() {
        return categoriaServicos.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> buscarPorId(@PathVariable Long id) {
        return categoriaServicos.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categorias> salvar(@RequestBody Categorias categoria) {
        Categorias novaCategoria = categoriaServicos.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorias> atualizar(@PathVariable Long id, @RequestBody Categorias categoria) {
        try {
            Categorias categoriaAtualizada = categoriaServicos.atualizar(id, categoria);
            return ResponseEntity.ok(categoriaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaServicos.deletar(id);
        return ResponseEntity.noContent().build();
    }
}