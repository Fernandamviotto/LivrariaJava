package com.biblioteca.biblioteca.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.biblioteca.biblioteca.application.Mappers;
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
    public LivroDTO cadastrarLivro(LivroDTO livbroDTO) {
        // Mapeia o DTO para a entidade e salvar no banco de dados
        Livro livro = livroMapper.LivroDTOtoEntity(livbroDTO);
        livro = livroRepository.save(livro);

        // Retorna o DTO mapeado a partir da entidade salva
        return livroMapper.livrtoDto(livro);
    }

    // Atualizar um usuário existente
    @Override
    public LivroDTO atualizarLivro(Long id, LivroDTO livroAtualizado) {
        Optional<Livro> livroExistente = livroRepository.findById(id);

        if (livroExistente.isEmpty()) {
            throw new CustomException("Livro não encontrado com o ID:" + id);
        }

        // Atualiza os dados do usuário existente com as informações do DTO
        Livro livro = livroExistente.get();
        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setEditora(livroAtualizado.getEditora());

        // Salvar o usuário atualizado no repositório
        livro = livroRepository.save(livro);

        // Retorna o DTO atualizado mapeado a partir da entidade salva
        return livroMapper.livrtoDto(livro);
    }

    // Remover um livro pelo ID
    @Override
    public void removerLivro(long id) {
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isEmpty()) {
            throw new CustomException("Livro não encontrado com o ID: " + id);
        }

        livroRepository.deleteById(id);
    }

    // Listar todos os usuários
    @Override
    public List<LivroDTO> listarTodosLivros() {
        // Obtém a lista de entidades de livros e a converte para uma lista de DTOs
        List<Livro> livros = livroRepository.findAll();
        return livros.stream()
                .map(livroMapper::livrtoDto)
                .collect(Collectors.toList());
    }

    // Buscar livro por ID
    @Override
    public LivroDTO buscarPorId(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isEmpty()) {
            throw new CustomException("Livro não encontrado com o ID: " + id);
        }

        // Retorna o DTO mapeado a partir da entidade encontrada
        return livroMapper.livrtoDto(livro.get());
    }

    // Buscar livro por titulo
    @Override
    public LivroDTO buscarPorTitulo(String titulo) {
        Optional<Livro> livro = livroRepository.findByTitulo(titulo);

        if (livro.isEmpty()) {
            throw new CustomException("Livro não encontrado com o titulo: " + titulo);
        }

        // retorna o DTO mapeado a partir da entidade encontrada
        return livroMapper.livrtoDto(livro.get());
    }
}
