package com.exemplo.agenda.controller;

import com.exemplo.agenda.model.Contato;
import com.exemplo.agenda.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public List<Contato> listarTodos() {
        return contatoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Contato buscarPorId(@PathVariable Long id) {
        return contatoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato criar(@Valid @RequestBody Contato contato) {
        return contatoService.criar(contato);
    }

    @PutMapping("/{id}")
    public Contato atualizar(@PathVariable Long id, @Valid @RequestBody Contato contato) {
        return contatoService.atualizar(id, contato);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        contatoService.remover(id);
    }
}
