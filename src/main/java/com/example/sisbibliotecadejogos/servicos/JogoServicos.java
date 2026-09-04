package com.example.sisbibliotecadejogos.servicos;

import com.example.sisbibliotecadejogos.entidades.Jogo;
import com.example.sisbibliotecadejogos.repositorios.JogoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoServicos {

    @Autowired
    private JogoRepositorio jogoRepository;

    public List<Jogo> listarTodos() {
        return jogoRepository.findAll();
    }

    public Optional<Jogo> buscarPorId(Long id) {
        return jogoRepository.findById(id);
    }

    public Jogo salvar(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public Jogo atualizar(Long id, Jogo jogoAtualizado) {
        return jogoRepository.findById(id).map(jogo -> {
            jogo.setNome(jogoAtualizado.getNome());
            jogo.setAnoLancamento(jogoAtualizado.getAnoLancamento());
            jogo.setPontuacao(jogoAtualizado.getPontuacao());
            jogo.setAvaliacaoPessoal(jogoAtualizado.getAvaliacaoPessoal());
            jogo.setEstudio(jogoAtualizado.getEstudio());
            jogo.setCategorias(jogoAtualizado.getCategorias());
            return jogoRepository.save(jogo);
        }).orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + id));
    }

    public void deletar(Long id) {
        jogoRepository.deleteById(id);
    }
}