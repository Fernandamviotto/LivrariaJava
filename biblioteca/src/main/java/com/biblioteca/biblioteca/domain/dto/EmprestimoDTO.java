package com.biblioteca.biblioteca.domain.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmprestimoDTO {
    private Long id;
    // Fk usuario
    // Fk livro
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String status;
    private Double multaAplicada;
}
