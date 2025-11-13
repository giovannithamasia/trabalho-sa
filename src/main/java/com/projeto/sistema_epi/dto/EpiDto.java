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
public class EpiDto {

    private int idEpi;

    @NotBlank(massage = "Nome não pode ser nulo")
    @Size(max = 120, massage = "Nome pode ultrapassar 120 caracteres")
    private String nome;

    @Size(max = 80, massage = "Tipo pode ultrapassar 80 caracteres")
    private String tipo;

    @Size(max = 255, massage = "Descricão pode ultrapassar 255 caracteres")
    private String descricao;

    @Size(max = 20, massage = "Tamanho pode ultrapassar 255 caracteres")
    private String tamanho;

    @NotNull(massage = "Validade não pode ser nula")
    private Date validade;

    @Size(max = 20, massage = "Situacao pode ultrapassar 20 caracteres")
    private String situacao;

}
