package com.projeto.sistema_epi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "colaborador")

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colaborador")
    private Long idColaborador;

    @Column (name = "nome")
    private String nome;

    @Column (name = "cpf")
    private String cpf;

    @Column (name = "cargo")
    private String cargo;

    @Column (name = "setor")
    private String setor;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @Column(name = "status_ativo")
    private boolean statusAtivo;

}
