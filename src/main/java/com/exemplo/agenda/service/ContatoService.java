package com.exemplo.agenda.service;

import com.exemplo.agenda.exception.ResourceNotFoundException;
import com.exemplo.agenda.model.Contato;
import com.exemplo.agenda.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    public Contato buscarPorId(Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato nao encontrado para o id " + id));
    }

    public Contato criar(Contato contato) {
        contato.setId(null);
        return contatoRepository.save(contato);
    }

    public Contato atualizar(Long id, Contato contatoAtualizado) {
        Contato contato = buscarPorId(id);
        contato.setNome(contatoAtualizado.getNome());
        contato.setEmail(contatoAtualizado.getEmail());
        contato.setTelefone(contatoAtualizado.getTelefone());
        contato.setObservacao(contatoAtualizado.getObservacao());
        return contatoRepository.save(contato);
    }

    public void remover(Long id) {
        Contato contato = buscarPorId(id);
        contatoRepository.delete(contato);
    }
}
