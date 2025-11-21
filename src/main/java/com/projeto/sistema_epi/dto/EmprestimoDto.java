
package com.projeto.sistema_epi.dto;

import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDate;

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

    private LocalDate dataPrevistaDevolucao;

    @Size(max = 255, message = "Observação não pode ultrapassar 255 caracteres")
    private String observacao;
}