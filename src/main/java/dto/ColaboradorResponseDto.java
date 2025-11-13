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
public class ColaboradorResponseDto {

    private int idColaborador;


    private String nome;


    private String cargo;


    private String setor;


    private Date dataAdmissao;


    private boolean statusAtivo;
}
