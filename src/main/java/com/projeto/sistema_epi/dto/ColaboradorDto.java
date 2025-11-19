package com.projeto.sistema_epi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class ColaboradorDto {

    private Long idColaborador;

    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @Size(max = 11, message = "Cpf não pode ultrapassar 11 caracteres")
    @NotBlank(message = "Cpf não pode ser vazio")
    private String cpf;

    @NotBlank(message = "Cargo não pode ser vazio")
    @Size(max = 80, message = "Cargo não pode ultrapassar 80 caracteres")
    private String cargo;

    @NotBlank(message = "Setor não pode ser vazio")
    @Size(max = 80, message = "Setor não pode ultrapassar 80 caracteres")
    private String setor;

    @PastOrPresent(message = "Data de admissao não pode ser futura")
    private LocalDate dataAdmissao;

    @NotNull(message = "Status não pode ser nulo")
    private boolean statusAtivo;
}