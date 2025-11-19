package com.projeto.sistema_epi.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmprestimoResponseDto {

    private Long idEmprestimo;

    private String nomeColaborador;

    private String nomeEpi;

    private LocalDateTime dataEmprestimo;

    private LocalDate dataPrevistaDevolucao;

    private LocalDateTime dataDevolucao;

    private String status;

    private String observacao;
}

