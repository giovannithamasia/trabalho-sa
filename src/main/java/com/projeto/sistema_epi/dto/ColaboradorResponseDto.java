package com.projeto.sistema_epi.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class ColaboradorResponseDto {

    private String nome;

    private String cargo;

    private String setor;

    private LocalDate dataAdmissao;

    private boolean statusAtivo;
}
