package com.projeto.sistema_epi.controller;

import com.projeto.sistema_epi.dto.EmprestimoDto;
import com.projeto.sistema_epi.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class EmprestimoController {

    private final Scanner sc = new Scanner(System.in);

    private final EmprestimoService emprestimoService;

    public void retirarEpi(){
        EmprestimoDto empDto = new EmprestimoDto();

        System.out.println("Informe o id do colaborador: ");
        empDto.setIdColaborador(sc.nextLong());

        System.out.println("Informe o id do EPI: ");
        empDto.setIdEpi(sc.nextLong());

        LocalDateTime dataEmprestimo = LocalDateTime.now();
        empDto.setDataEmprestimo(dataEmprestimo);
        System.out.println("Data de empréstimo registrada: " + dataEmprestimo);

        LocalDate dataPrevistaDevolucao = LocalDate.of(2025, 11, 30);
        empDto.setDataPrevistaDevolucao(dataPrevistaDevolucao);
        System.out.println("data prevista da devolução: " + dataPrevistaDevolucao);

        sc.nextLine();
        System.out.println("Observação:");
        empDto.setObservacao(sc.nextLine());

        emprestimoService.retirarEpi(empDto);
    }
}
