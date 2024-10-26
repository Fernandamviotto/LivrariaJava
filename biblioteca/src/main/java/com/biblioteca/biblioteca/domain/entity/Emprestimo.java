package com.biblioteca.biblioteca.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "emprestimo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Usando auto increment
    private Long id;

    @Column(name = "data_emprestimo", nullable = false)
    private LocalDate dataemprestimo;

    @Column(name = "data_devolucao_prevista", nullable = false)
    private LocalDate dataDevolucaoPrevista;

    @Column(name = "data_devolucao_realizada", nullable = false)
    private LocalDate dataDevolucaoRealizada;

    @Column(nullable = false)
    private String status;

    @Column(name = "multa_aplicada", nullable = false)
    private Double multaAplicada;
}
