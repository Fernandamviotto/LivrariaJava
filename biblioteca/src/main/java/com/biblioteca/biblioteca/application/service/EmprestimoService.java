package com.biblioteca.biblioteca.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.application.Mappers;
import com.biblioteca.biblioteca.domain.dto.EmprestimoDTO;
import com.biblioteca.biblioteca.domain.entity.Emprestimo;
import com.biblioteca.biblioteca.domain.repository.IEmprestimoRepository;
import com.biblioteca.biblioteca.domain.service.IEmprestimoService;

@Service
public class EmprestimoService implements IEmprestimoService {

    @Autowired
    private IEmprestimoRepository emprestimoRepository;

    @Autowired
    private Mappers emprestimoMapper;

    @Override
    public EmprestimoDTO cadastrarEmprestimo(EmprestimoDTO emprestimoDTO) {
        // Mapeia o DTO para a entidade e salvar no banco de dados
        Emprestimo emprestimo = emprestimoMapper.EmprestimoDTOtoEntity(emprestimoDTO);
        emprestimo = emprestimoRepository.save(emprestimo);

        // Retorna o DTO mapeado a partir da entidade salva
        return emprestimoMapper.EmprestimotoDto(emprestimo);
    }

    @Override
    public EmprestimoDTO registrarDevolucao(Long id, EmprestimoDTO registrarDevolucao) {
        // registrar devolucao e validar se tem multa e calcular a multa
        Emprestimo emprestimo = emprestimoMapper.EmprestimoDTOtoEntity(registrarDevolucao);
        emprestimo = emprestimoRepository.save(emprestimo);

        throw new UnsupportedOperationException("Unimplemented method 'registrarDevolucao'");
    }

    @Override
    public EmprestimoDTO buscarEmprestimoIdUsuario(long id, long UsuarioDTO, EmprestimoDTO buscarEmprestimoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEmprestimoIdUsuario'");
    }

    @Override
    public EmprestimoDTO buscarEmprestimoIdLivro(long id, long LivroDTO, EmprestimoDTO buscarEmprestimoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEmprestimoIdLivro'");
    }

}
