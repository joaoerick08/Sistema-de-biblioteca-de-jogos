package com.example.sisbibliotecadejogos.controladores;

import com.example.sisbibliotecadejogos.entidades.Estudio;
import com.example.sisbibliotecadejogos.servicos.EstudioServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioControlador {

    @Autowired
    private EstudioServicos estudioServicos;

    @GetMapping
    public List<Estudio> listarTodos() {
        return estudioServicos.listarTodos();
    }

    @GetMapping("/{id}")
    public Estudio buscarPorId(@PathVariable Long id) {
        return estudioServicos.buscarPorId(id);
    }

    @PostMapping
    public Estudio criar(@RequestBody Estudio estudio) {
        return estudioServicos.salvar(estudio);
    }

    @PutMapping("/{id}")
    public Estudio atualizar(@PathVariable Long id, @RequestBody Estudio estudio) {
        return estudioServicos.atualizar(id, estudio);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        estudioServicos.deletar(id);
    }
}