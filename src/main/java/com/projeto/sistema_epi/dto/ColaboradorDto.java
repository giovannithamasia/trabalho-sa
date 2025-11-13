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
public class ColaboradorDto {

    private int idColaborador;

    @NotBlank(massage = "Nome não pode ser vazio")
    private String nome;

    @Size(max = 11, message = "Cpf não pode ultrapassar 11 caracteres")
    @NotBlank(massage = "Cpf não pode ser vazio")
    private String cpf;

    @NotBlank(massage = "Cargo não pode ser vazio")
    @Size(max = 80, message = "Cargo não pode ultrapassar 80 caracteres")
    private String cargo;

    @NotBlank(massage = "Setor não pode ser vazio")
    @Size(max = 80, message = "setor não pode ultrapassar 80 caracteres")
    private String setor;

    @NotNull(massage = "Data da adimição nao pode ser nula");
    @PastOrPresent(massage = "Data de adimição nao pode ser ");
    private Date dataAdmissao;

    @NotNull(massage = "Status não pode ser nulo");
    private boolean statusAtivo;