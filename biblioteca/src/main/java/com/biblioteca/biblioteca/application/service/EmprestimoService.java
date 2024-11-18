package com.biblioteca.biblioteca.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.application.Mappers;
import com.biblioteca.biblioteca.domain.dto.EmprestimoDTO;
import com.biblioteca.biblioteca.domain.entity.Emprestimo;
import com.biblioteca.biblioteca.domain.repository.IEmprestimoRepository;
import com.biblioteca.biblioteca.domain.service.IEmprestimoService;
import com.biblioteca.biblioteca.shared.CustomException;
import com.biblioteca.biblioteca.shared.StatusEmprestimo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmprestimoService implements IEmprestimoService {

    @Autowired
    private IEmprestimoRepository emprestimoRepository;

    @Autowired
    private Mappers emprestimoMapper;

    @Override
    public EmprestimoDTO cadastrarEmprestimo(EmprestimoDTO emprestimoDTO) {
        // Mapeia o DTO para a entidade e salva no banco de dados
        Emprestimo emprestimo = emprestimoMapper.EmprestimoDTOtoEntity(emprestimoDTO);
        emprestimo.setStatus(StatusEmprestimo.ATIVO);

        // Salva o empréstimo no repositório
        emprestimo = emprestimoRepository.save(emprestimo);

        // Retorna o DTO mapeado a partir da entidade salva
        return emprestimoMapper.EmprestimotoDto(emprestimo);

    }

    @Override
    public EmprestimoDTO registrarDevolucao(Long id, EmprestimoDTO registrarDevolucao) {
        // Busca o emprestimo
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Emprestimo não encontrado com o ID: " + id));

        // Registra devolução
        emprestimo.setDataDevolucaoRealizada(registrarDevolucao.getDataDevolucaoRealizada());
        emprestimo
                .setStatus(registrarDevolucao.getDataDevolucaoRealizada().isAfter(emprestimo.getDataDevolucaoPrevista())
                        ? StatusEmprestimo.EM_ATRASO
                        : StatusEmprestimo.CONCLUIDO);
        emprestimo.setMultaAplicada(registrarDevolucao.getMultaAplicada());

        // Salva a devolução no repositório
        emprestimo = emprestimoRepository.save(emprestimo);

        // Retorna o DTO mapeado a partir da entidade salva
        return emprestimoMapper.EmprestimotoDto(emprestimo);
    }

    @Override
    public List<EmprestimoDTO> consultarHistoricoPorUsuario(Long id) {
        // busca todos os emprestimos do usuario
        return emprestimoRepository.findByUsuario(0).stream()
                .map(emprestimoMapper::EmprestimotoDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmprestimoDTO> consultarHistoricoPorLivro(Long id) {
        // busca todos os emprestimos do livro
        return emprestimoRepository.findByLivro(0).stream()
                .map(emprestimoMapper::EmprestimotoDto)
                .collect(Collectors.toList());
    }

}
