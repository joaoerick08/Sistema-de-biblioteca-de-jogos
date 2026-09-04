package com.example.sisbibliotecadejogos.servicos;

import com.example.sisbibliotecadejogos.entidades.Estudio;
import com.example.sisbibliotecadejogos.repositorios.EstudioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudioServicos {

    @Autowired
    private EstudioRepositorio estudioRepositorio;

    public List<Estudio> listarTodos() {
        return estudioRepositorio.findAll();
    }

    public Estudio buscarPorId(Long id) {
        return estudioRepositorio.findById(id).orElse(null);
    }

    public Estudio salvar(Estudio estudio) {
        return estudioRepositorio.save(estudio);
    }

    public Estudio atualizar(Long id, Estudio estudioAtualizado) {
        Estudio estudio = estudioRepositorio.findById(id).orElse(null);
        if (estudio != null) {
            estudio.setNome(estudioAtualizado.getNome());
            estudio.setPais(estudioAtualizado.getPais());
            return estudioRepositorio.save(estudio);
        }
        return null;
    }

    public void deletar(Long id) {
        estudioRepositorio.deleteById(id);
    }
}