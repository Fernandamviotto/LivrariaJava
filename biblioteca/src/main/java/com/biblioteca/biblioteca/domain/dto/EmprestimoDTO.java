package com.biblioteca.biblioteca.domain.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmprestimoDTO {
    private Long id;
    private Long usuarioId;
    private Long livroId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoRealizada;
    private String status;
    private Double multaAplicada;
}
