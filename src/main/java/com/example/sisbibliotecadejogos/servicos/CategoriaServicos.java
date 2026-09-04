package com.example.sisbibliotecadejogos.servicos;

import com.example.sisbibliotecadejogos.entidades.Categorias;
import com.example.sisbibliotecadejogos.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicos {

    @Autowired
    private CategoriaRepositorio CategoriaRepositorio;

    public List<Categorias> listarTodos() {
        return CategoriaRepositorio.findAll();
    }

    public Optional<Categorias> buscarPorId(Long id) {
        return CategoriaRepositorio.findById(id);
    }

    public Categorias salvar(Categorias categorias) {
        return CategoriaRepositorio.save(categorias);
    }

    public Categorias atualizar(Long id, Categorias categoriaAtualizada) {
        return CategoriaRepositorio.findById(id).map(categoria -> {
            categoria.setNome(categoriaAtualizada.getNome());
            return CategoriaRepositorio.save(categoria);
        }).orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + id));
    }

    public void deletar(Long id) {
        CategoriaRepositorio.deleteById(id);
    }
}