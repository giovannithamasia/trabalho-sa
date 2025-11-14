package com.projeto.sistema_epi.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EpiResponseDto {


    private String nome;

    private String tipo;

    private String descricao;

    private String tamanho;

    private LocalDate validade;

    private String situacao;

}
