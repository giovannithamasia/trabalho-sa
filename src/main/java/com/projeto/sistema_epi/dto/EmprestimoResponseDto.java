package com.projeto.sistema_epi.dto;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmprestimoResponseDto {

    private Long idEmprestimo;

    private String nomeColaborador;

    private String nomeEpi;

    private LocalDate dataEmprestimo;

    private LocalDate dataPrevistaDevolucao;

    private LocalDate dataDevolucao;

    private String status;

    private String observacao;
}

