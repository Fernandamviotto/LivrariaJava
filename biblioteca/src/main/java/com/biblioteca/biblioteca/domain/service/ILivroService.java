package com.biblioteca.biblioteca.domain.service;

import com.biblioteca.biblioteca.domain.dto.LivroDTO;

public interface ILivroService {

    LivroDTO cadastrarLivro(LivroDTO livroDTO);

    LivroDTO atualizarLivro(Long id, LivroDTO livroAtualizado);
}
