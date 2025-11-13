package com.projeto.sistema_epi.dto;


import lombok.*;

import java.util.Date;

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

    private Date dataAdmissao;

    private boolean statusAtivo;
}
