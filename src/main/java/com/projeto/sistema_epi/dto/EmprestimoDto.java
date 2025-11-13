
package dto;

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
public class EmprestimoDto {

    private int idEmprestimo;
    private int idColaborador;
    private int idEpi;


    @NotNull(massage = "Data do Emprestimo não pode ser nula")
    @PastOrPresent(massage = "Data do emprestimo não pode ser futura")
    private Date dataEmprestimo;

    @NotNull(massage = "Data Prevista pra devolução não pode ser nula")
    private Date dataPrevistaDevolução;

    @NotNull(massage = "Data da devolução não pode ser nula")
    @PastOrPresent(massage = "Data da devolução não pode ser futura")
    private Date dataDevolucao;

    @NotNull(massage = "Status não pode ser nulo")
    @Size(max = 20, masage = "Status não pode ultrapassar de 20 caracteres")
    private String status;

    @Size(max = 255, massage = "Observação mão pode ultrapassar 255 caracteres")
    private String observacao;
}