package com.projeto.sistema_epi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "epi")

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EpiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_epi")
    private int idEpi;

    @Column(name = "nome_epi")
    private String nomeEpi;

    @Column(name = "tipo_epi")
    private String tipoEpi;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "validade")
    private LocalDate validade;

    @Column (name = "situacao")
    private String situacao;

}
