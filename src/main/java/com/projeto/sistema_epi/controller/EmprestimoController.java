package com.projeto.sistema_epi.controller;

import com.projeto.sistema_epi.dto.EmprestimoDto;
import com.projeto.sistema_epi.dto.EmprestimoResponseDto;
import com.projeto.sistema_epi.repository.ColaboradorRepository;
import com.projeto.sistema_epi.repository.EmprestimoRepository;
import com.projeto.sistema_epi.repository.EpiRepository;
import com.projeto.sistema_epi.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class EmprestimoController {

    private final Scanner sc = new Scanner(System.in);

    private final EmprestimoService emprestimoService;

    private final EmprestimoRepository emprestimoRepository;

    private final ColaboradorRepository colaboradorRepository;

    private final EpiRepository epiRepository;

    private final DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void retirarEpi(){
        EmprestimoDto empDto = new EmprestimoDto();

        System.out.println("Informe o id do colaborador: ");
        empDto.setIdColaborador(sc.nextLong());
        sc.nextLine();

        if (!colaboradorRepository.findById(empDto.getIdColaborador()).isPresent()){
            System.out.println("Colaborador não encontrado");
            return;
        }
        System.out.println("Informe o id do EPI: ");
        empDto.setIdEpi(sc.nextLong());
        sc.nextLine();

        if (!epiRepository.findById(empDto.getIdEpi()).isPresent()){
            System.out.println("Epi não encontrado");
            return;
        }

        System.out.println("Data prevista de devolucao (dd/MM/yyyy): ");
        LocalDate dataPrevistaDevolucao = LocalDate.parse(sc.nextLine(),date);
        empDto.setDataPrevistaDevolucao(dataPrevistaDevolucao);

        System.out.println("Observação:");
        empDto.setObservacao(sc.nextLine());

        emprestimoService.retirarEpi(empDto);

        System.out.println("Empréstimo realizado com sucesso!!");
    }
    public void devolverEpi(){
        System.out.println("Informe o id do emprestimo que a ser devolvido");
        Long id = sc.nextLong();

        if (!emprestimoRepository.findById(id).isPresent()){
            System.out.println("Empréstimo não encontrado");
            return;
        }

        emprestimoService.devolverEpi(id);

        System.out.println("Devolução realizada com sucesso!!");
    }
    public List<EmprestimoResponseDto> listarEmprestimos(){
        return emprestimoService.listarEmprestimos();
    }
}