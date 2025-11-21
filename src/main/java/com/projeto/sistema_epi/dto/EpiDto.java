package com.projeto.sistema_epi.dto;

import jakarta.validation.constraints.NotBlank;


import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class EpiDto {

    private Long idEpi;

    @NotBlank(message = "Nome não pode ser nulo")
    @Size(max = 120, message = "Nome não pode ultrapassar 120 caracteres")
    private String nome;

    @Size(max = 80, message = "Tipo não pode ultrapassar 80 caracteres")
    private String tipo;

    @Size(max = 255, message = "Descricão não pode ultrapassar 255 caracteres")
    private String descricao;

    @Size(max = 20, message = "Tamanho não pode ultrapassar 20 caracteres")
    private String tamanho;

    private LocalDate validade;


}
