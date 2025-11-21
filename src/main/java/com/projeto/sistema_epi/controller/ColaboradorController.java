package com.projeto.sistema_epi.controller;

import com.projeto.sistema_epi.dto.ColaboradorDto;
import com.projeto.sistema_epi.dto.ColaboradorResponseDto;
import com.projeto.sistema_epi.repository.ColaboradorRepository;
import com.projeto.sistema_epi.service.ColaboradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;
    private final Scanner sc = new Scanner(System.in);
    private final ColaboradorRepository colaborador;

    private final DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void cadastrar(){
        ColaboradorDto dto = new ColaboradorDto();

        System.out.println("Nome: ");
        dto.setNome(sc.nextLine());
        System.out.println("Cpf: ");
        dto.setCpf(sc.nextLine());

        if (colaborador.existsByCpf(dto.getCpf())) {
            System.out.println("CPF já cadastrado");
            return;
        }

        System.out.println("Cargo: ");
        dto.setCargo(sc.nextLine());
        System.out.println("Setor: ");
        dto.setSetor(sc.nextLine());

        System.out.println("Data de admissao (dd/MM/yyyy): ");
        LocalDate dataAdmissao = LocalDate.parse(sc.nextLine(),date);
        dto.setDataAdmissao(dataAdmissao);

        System.out.println("Status ativo");
        dto.setStatusAtivo(sc.nextBoolean());

        sc.nextLine();

        colaboradorService.cadastroColaborador(dto);

        System.out.println("Colaborador cadastrado com sucesso!!");
    }
    public List<ColaboradorResponseDto> listar(){
       return colaboradorService.listarColaboradores();
    }

    public void atualizar(){
        ColaboradorDto dto = new ColaboradorDto();

        System.out.println("Informe o id que vc deseja atualizar");
        Long id = sc.nextLong();
        sc.nextLine();


        if (!colaborador.findById(id).isPresent()){
            System.out.println("Colaborador não encontrado");
            return;
        }

        System.out.println("Nome do Colaborador: ");
        dto.setNome(sc.nextLine());
        System.out.println("Cpf: ");
        dto.setCpf(sc.nextLine());
        System.out.println("Cargo: ");
        dto.setCargo(sc.nextLine());
        System.out.println("Setor: ");
        dto.setSetor(sc.nextLine());

        System.out.println("Data de admissao (dd/MM/yyyy): ");
        LocalDate dataAdmissao = LocalDate.parse(sc.nextLine(),date);
        dto.setDataAdmissao(dataAdmissao);

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

        if (!colaborador.findById(idRemover).isPresent()){
            System.out.println("Colaborador não encontrado");
            return;
        }

        System.out.println("tem certeza que quer deletar (digite 'excluir' para deletar)");
        String resposta = sc.nextLine();

        if (!resposta.equalsIgnoreCase("excluir")){
            System.out.println("Exclusão cancelada.");
            return;
        }

        colaboradorService.deletarColaborador(idRemover);
        System.out.println("Colaborador removido por id!!");

    }
}
