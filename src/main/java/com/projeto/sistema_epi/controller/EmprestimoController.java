package com.projeto.sistema_epi.controller;

import com.projeto.sistema_epi.dto.EmprestimoDto;
import com.projeto.sistema_epi.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class EmprestimoController {

    private final Scanner sc = new Scanner(System.in);

    private final EmprestimoService emprestimoService;

    private final DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void retirarEpi(){
        EmprestimoDto empDto = new EmprestimoDto();

        System.out.println("Informe o id do colaborador: ");
        empDto.setIdColaborador(sc.nextLong());

        System.out.println("Informe o id do EPI: ");
        empDto.setIdEpi(sc.nextLong());

        sc.nextLine();

        System.out.println("Data de Emprestimo (dd/MM/yyyy): ");
        LocalDate dataEmprestimo = LocalDate.parse(sc.nextLine(), date);
        empDto.setDataEmprestimo(dataEmprestimo.atStartOfDay());


        System.out.println("Data prevista de devolucao (dd/MM/yyyy): ");
        LocalDate dataPrevistaDevolucao = LocalDate.parse(sc.nextLine(),date);
        empDto.setDataPrevistaDevolucao(dataPrevistaDevolucao);

        sc.nextLine();
        System.out.println("Observação:");
        empDto.setObservacao(sc.nextLine());

        emprestimoService.retirarEpi(empDto);
    }
    public void devolverEpi(){
        System.out.println("Informe o id do emprestimo que a ser devolvido");
        Long id = sc.nextLong();


        emprestimoService.devolverEpi(id);
    }
}