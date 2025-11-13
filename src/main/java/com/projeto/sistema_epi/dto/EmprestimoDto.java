
package com.projeto.sistema_epi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class EmprestimoDto {

    private int idEmprestimo;
    private int idColaborador;
    private int idEpi;


    @NotNull(message = "Data do Emprestimo não pode ser nula")
    @PastOrPresent(message = "Data do emprestimo não pode ser futura")
    private Date dataEmprestimo;

    @NotNull(message = "Data Prevista pra devolução não pode ser nula")
    private Date dataPrevistaDevolução;

    @NotNull(message = "Data da devolução não pode ser nula")
    @PastOrPresent(message = "Data da devolução não pode ser futura")
    private Date dataDevolucao;

    @NotNull(message = "Status não pode ser nulo")
    @Size(max = 20, message = "Status não pode ultrapassar de 20 caracteres")
    private String status;

    @Size(max = 255, message = "Observação mão pode ultrapassar 255 caracteres")
    private String observacao;
}