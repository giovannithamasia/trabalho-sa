package com.projeto.sistema_epi.controller;

import com.projeto.sistema_epi.dto.EpiDto;
import com.projeto.sistema_epi.service.EpiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class EpiController {

    private final EpiService epiService;

    private final Scanner sc = new Scanner(System.in);

    public void cadastrarEpi(){
        EpiDto epiDto = new EpiDto();

        System.out.println("Nome do EPI: ");
        epiDto.setNome(sc.nextLine());
        System.out.println("Tipo: ");
        epiDto.setTipo(sc.nextLine());
        System.out.println("Descrição: ");
        epiDto.setDescricao(sc.nextLine());
        System.out.println("Tamanho: ");
        epiDto.setTamanho(sc.nextLine());
        LocalDate validade = LocalDate.of(2025, 11, 30);
        System.out.println("Data de validade " + validade);
        System.out.println("Situacao: ");
        epiDto.setSituacao(sc.nextLine());

        epiService.cadastrarEpi(epiDto);

        System.out.println("EPI cadastrado com sucesso!!");

    }
    public void atualizar(){
        EpiDto epiDto = new EpiDto();

        System.out.println("Informe o id que vc deseja  atualizar da EPI: ");
        sc.nextLine();

        System.out.println("Nome do EPI: ");
        epiDto.setNome(sc.nextLine());
        System.out.println("Tipo: ");
        epiDto.setTipo(sc.nextLine());
        System.out.println("Descrição: ");
        epiDto.setDescricao(sc.nextLine());
        System.out.println("Tamanho: ");
        epiDto.setTamanho(sc.nextLine());
        LocalDate validade = LocalDate.of(2025, 11, 30);
        System.out.println("Data de validade " + validade);
        System.out.println("Situacao: ");
        epiDto.setSituacao(sc.nextLine());

        epiService.atualizarEpi(idEPI, epiDto);

        System.out.println("EPI atualizado com sucesso");

    }
    public void deletar(){

        System.out.println("tem certeza que quer deletar (digite 'excluir' para deletar)");
        String resposta = sc.nextLine();

        }

    }
}
