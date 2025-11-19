package com.projeto.sistema_epi.controller;

import com.projeto.sistema_epi.dto.ColaboradorDto;
import com.projeto.sistema_epi.service.ColaboradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;
    private final Scanner sc = new Scanner(System.in);

    public void cadastrar(){
        ColaboradorDto dto = new ColaboradorDto();

        System.out.println("Nome: ");
        dto.setNome(sc.nextLine());
        System.out.println("Cpf: ");
        dto.setCpf(sc.nextLine());
        System.out.println("Cargo: ");
        dto.setCargo(sc.nextLine());
        System.out.println("Setor: ");
        dto.setSetor(sc.nextLine());
        LocalDate date = LocalDate.of(2020, 10, 11);
        System.out.println("Data de admissao " + date);
        dto.setDataAdmissao(date);
        System.out.println("Status ativo");
        dto.setStatusAtivo(sc.nextBoolean());

        sc.nextLine();

        colaboradorService.cadastroColaborador(dto);

        System.out.println("Colaborador cadastrado com sucesso!!");
    }
    public void atualizar(){
        ColaboradorDto dto = new ColaboradorDto();

        System.out.println("Informe o id que vc deseja atualizar");
        Long id = sc.nextLong();
        sc.nextLine();
        System.out.println("Nome do Colaborador: ");
        dto.setNome(sc.nextLine());
        System.out.println("Cpf: ");
        dto.setCpf(sc.nextLine());
        System.out.println("Cargo: ");
        dto.setCargo(sc.nextLine());
        System.out.println("Setor: ");
        dto.setSetor(sc.nextLine());
        LocalDate date = LocalDate.of(2020, 10, 11);
        System.out.println("Data de admissao " + date);
        dto.setDataAdmissao(date);
        System.out.println("Status ativo");
        dto.setStatusAtivo(sc.nextBoolean());

        sc.nextLine();

        colaboradorService.atualizarColaborador(id, dto);

        System.out.println("Colaborador atualizado com sucesso!!");
    }
    public void deletar(){
        System.out.println("Informe o id a ser excluido");
        Long idRemover = sc.nextLong();

        sc.nextLine();

        System.out.println("tem certeza que quer deletar (digite 'excluir' para deletar)");
        String resposta = sc.nextLine();

        if (!resposta.equalsIgnoreCase("excluir")){
            System.out.println("Exclusão cancelada.");
        }
        colaboradorService.deletarColaborador(idRemover);

        System.out.println("Colaborador removido por id!!");
    }
}
