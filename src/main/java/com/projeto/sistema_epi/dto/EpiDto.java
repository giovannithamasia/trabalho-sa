package com.projeto.sistema_epi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class EpiDto {

    private int idEpi;

    @NotBlank(message = "Nome não pode ser nulo")
    @Size(max = 120, message = "Nome pode ultrapassar 120 caracteres")
    private String nome;

    @Size(max = 80, message = "Tipo pode ultrapassar 80 caracteres")
    private String tipo;

    @Size(max = 255, message = "Descricão pode ultrapassar 255 caracteres")
    private String descricao;

    @Size(max = 20, message = "Tamanho pode ultrapassar 20 caracteres")
    private String tamanho;

    @NotNull(message = "Validade não pode ser nula")
    private LocalDate validade;

    @Size(max = 20, message = "Situacao pode ultrapassar 20 caracteres")
    private String situacao;

}
