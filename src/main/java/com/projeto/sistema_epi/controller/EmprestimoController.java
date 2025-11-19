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

        LocalDate dataPrevistaDevolucao = LocalDate.of(2025, 11, 30);
        empDto.setObservacao(sc.nextLine());

        emprestimoService.retirarEpi(empDto);
    }
}
