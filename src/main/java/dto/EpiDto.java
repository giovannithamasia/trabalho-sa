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

    @NotBlank
    private String nome;

    @NotBlank
    private String tipo;

    @NotBlank
    private String tamanho;

    @NotNull
    private Date validade;

    @NotBlank
    private String situacao;

}
