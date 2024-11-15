package com.biblioteca.biblioteca.domain.service;

import com.biblioteca.biblioteca.domain.dto.EmprestimoDTO;

public interface IEmprestimoService {

    // Realizar e registrar empréstimos de livros
    EmprestimoDTO cadastrarEmprestimo(EmprestimoDTO emprestimoDTO);

    // Registrar devoluções
    EmprestimoDTO registrarDevolucao(Long id, EmprestimoDTO registrarDevolucao);

    // Consultar histórico de empréstimos por usuário
    EmprestimoDTO buscarEmprestimoIdUsuario(long id, long UsuarioDTO, EmprestimoDTO buscarEmprestimoId);

    // Consultar histórico de empréstimos por livro
    EmprestimoDTO buscarEmprestimoIdLivro(long id, long LivroDTO, EmprestimoDTO buscarEmprestimoId);
}
