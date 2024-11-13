package com.biblioteca.biblioteca.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.domain.repository.IEmprestimoRepository;
import com.biblioteca.biblioteca.domain.service.IEmprestimoService;

@Service
public class EmprestimoService  implements IEmprestimoService {

    @Autowired
    private IEmprestimoRepository emprestimoRepository;


    @Autowired
    private Mappers emprestimoMapper;
    
}
