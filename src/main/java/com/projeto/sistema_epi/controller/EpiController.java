
package com.projeto.sistema_epi.controller;

import com.projeto.sistema_epi.dto.EpiDto;
import com.projeto.sistema_epi.dto.EpiResponseDto;
import com.projeto.sistema_epi.repository.EpiRepository;
import com.projeto.sistema_epi.service.EpiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class EpiController {

    private final EpiService epiService;

    private final EpiRepository epiRepository;

    private final Scanner sc = new Scanner(System.in);

    private final DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

        System.out.println("Data de validade (dd/MM/yyyy): ");
        LocalDate validade = LocalDate.parse(sc.nextLine(),date);
        epiDto.setValidade(validade);

        epiService.cadastrarEpi(epiDto);

        System.out.println("EPI cadastrado com sucesso!!");

    }
    public List<EpiResponseDto> listar(){
        return epiService.listarEPIs();
    }
    public void atualizar(){
        EpiDto epiDto = new EpiDto();

        System.out.println("Informe o id que vc deseja  atualizar da EPI: ");
        Long idEPI = sc.nextLong();
        sc.nextLine();

        if (!epiRepository.findById(idEPI).isPresent()){
            System.out.println("Epi não encontrado");
            return;
        }

        System.out.println("Nome do EPI: ");
        epiDto.setNome(sc.nextLine());
        System.out.println("Tipo: ");
        epiDto.setTipo(sc.nextLine());
        System.out.println("Descrição: ");
        epiDto.setDescricao(sc.nextLine());
        System.out.println("Tamanho: ");
        epiDto.setTamanho(sc.nextLine());

        System.out.println("Data de validade (dd/MM/yyyy): ");
        LocalDate validade = LocalDate.parse(sc.nextLine(),date);
        epiDto.setValidade(validade);

        epiService.atualizarEpi(idEPI, epiDto);

        System.out.println("EPI atualizado com sucesso");

    }
    public void deletar(){
        System.out.println("Informe o id para ser excluido");
        Long idRemover = sc.nextLong();
        sc.nextLine();

        if (!epiRepository.findById(idRemover).isPresent()){
            System.out.println("Epi não encontrado");
            return;
        }

        System.out.println("tem certeza que quer deletar (digite 'excluir' para deletar)");
        String resposta = sc.nextLine();

        if (!resposta.equalsIgnoreCase("excluir")){
            System.out.println("Exclusão cancelada.");
            return;
        }
        epiService.deletarEpi(idRemover);

        System.out.println("EPI removido por id!!");
    }
}
