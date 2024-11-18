package com.biblioteca.biblioteca.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.biblioteca.biblioteca.domain.dto.EmprestimoDTO;
import com.biblioteca.biblioteca.domain.service.IEmprestimoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

public class EmprestimoController {

    @Autowired
    private IEmprestimoService emprestimoService;

    // Sera o metodo post
    @PostMapping
    public ResponseEntity<EmprestimoDTO> cadastrarEmprestimo(@RequestBody @Valid EmprestimoDTO emprestimoDTO) {
        EmprestimoDTO novoEmprestimo = emprestimoService.cadastrarEmprestimo(emprestimoDTO);

        return ResponseEntity.status(201).body(novoEmprestimo); // Retorna 201 Created
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<EmprestimoDTO> registrarDevolucao(@PathVariable Long id,
            @RequestBody @Valid EmprestimoDTO registrarDevolucao) {
        EmprestimoDTO emprestimoDevolvido = emprestimoService.registrarDevolucao(id, registrarDevolucao);

        return ResponseEntity.ok(emprestimoDevolvido);
    }

    @GetMapping("/historico/usuario/{id}")
    public ResponseEntity<List<EmprestimoDTO>> consultarHistoricoPorUsuario(@PathVariable Long UsuarioDTO) {
        return ResponseEntity.ok(emprestimoService.consultarHistoricoPorUsuario(UsuarioDTO));
    }

    @GetMapping("/historico/livro/{id}")
    public ResponseEntity<List<EmprestimoDTO>> consultarHistoricoPorLivro(@PathVariable Long LivroDTO) {
        return ResponseEntity.ok(emprestimoService.consultarHistoricoPorLivro(LivroDTO));
    }

}
