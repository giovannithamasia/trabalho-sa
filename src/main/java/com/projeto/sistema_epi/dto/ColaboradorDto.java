package com.projeto.sistema_epi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class ColaboradorDto {

    private int idColaborador;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String cargo;

    @NotBlank
    private String setor;

    @NotNull
    @PastOrPresent
    private Date dataAdmissao;

    @NotNull
    private boolean statusAtivo;

}
