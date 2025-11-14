package com.projeto.sistema_epi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private int idEmprestimo;

    @ManyToOne
    @JoinColumn (name = "id_colaborador",referencedColumnName = "id_colaborador")
    private ColaboradorEntity colaborador;

    @ManyToOne
    @JoinColumn (name = "id_epi",referencedColumnName = "id_epi")
    private EpiEntity epi;

    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;

    @Column (name = "data_prevista_devolucao")
    private LocalDate dataPrevistaDevolucao;

    @Column (name = "data_devolucao")
    private LocalDate dataDevolucao;

    @Column (name = "status")
    private String status;

    @Column (name = "observacao")
    private String observacao;

}
