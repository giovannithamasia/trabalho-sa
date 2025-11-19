package com.projeto.sistema_epi.controller;

import com.projeto.sistema_epi.dto.EmprestimoDto;
import com.projeto.sistema_epi.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class EmprestimoController {

    private final Scanner sc = new Scanner(System.in);

    private final EmprestimoService emprestimoService;

    public void retirarEpi(){
        EmprestimoDto empDto = new EmprestimoDto();

        System.out.println("Informe o id do colaborador que realizou o emprestimo: ");
        empDto.setIdColaborador(sc.nextInt());
        System.out.println("Informe o id do epi que sera retirado para emprestimo: ");
        empDto.setIdEpi(sc.nextInt());
        LocalDate dataEmprestimo = LocalDate.of(2025, 11, 18);
        System.out.println("data de emprestimo " + dataEmprestimo);
        LocalDate dataPrevistaDevolucao = LocalDate.of(2025, 11, 30);
        System.out.println("data prevista da devolução" + dataPrevistaDevolucao);
        System.out.println("Observacao: ");
        empDto.setObservacao(sc.nextLine());

        emprestimoService.retirarEpi(empDto);
    }
}
