
package com.projeto.sistema_epi.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class EmprestimoDto {

    private Long idEmprestimo;
    private Long idColaborador;
    private Long idEpi;


    @NotNull(message = "Data do Emprestimo não pode ser nula")
    @PastOrPresent(message = "Data do emprestimo não pode ser futura")
    private LocalDateTime dataEmprestimo;

    @NotNull(message = "Data Prevista pra devolução não pode ser nula")
    private LocalDate dataPrevistaDevolucao;

    @PastOrPresent(message = "Data da devolução não pode ser futura")
    private LocalDateTime dataDevolucao;

    @Size(max = 255, message = "Observação mão pode ultrapassar 255 caracteres")
    private String observacao;
}