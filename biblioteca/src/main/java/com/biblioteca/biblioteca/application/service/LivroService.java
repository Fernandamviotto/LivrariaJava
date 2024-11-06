package com.biblioteca.biblioteca.application.service;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.biblioteca.biblioteca.domain.dto.LivroDTO;
import com.biblioteca.biblioteca.domain.entity.Livro;
import com.biblioteca.biblioteca.domain.repository.ILivroRepository;
import com.biblioteca.biblioteca.domain.service.ILivroService;
import com.biblioteca.biblioteca.shared.CustomException;

public class LivroService implements ILivroService {

    @Autowired
    private ILivroRepository livroRepository;

    @Autowired
    private Mappers livroMapper;

    // Cadastrar um novo livro
    @Override
    public LivroDTO cadastrarLivro(LivroDTO livroDTO) {
        // Mapeia o DTO para a entidade e salvar no banco de dados
        Livro livro = livroMapper.LivroDTOtoEntity(livroDTO);
        livro = livroRepository.save(livro);

        // Retorna o DTO mapeado a partir da entidade salva
        return livroMapper.LivrotoDto(livro);
    }

    // Atualizar um usuário existente
    @Override
    public LivroDTO atualizarLivro(Long id, LivroDTO livroAtualizado) {
        Optional<Livro> livroExistente = livroRepository.findById(id);

        if (livroExistente.isEmpty()) {
            throw new CustomException("Livro não encontrado com o ID:" + id);
        }
    }

}
