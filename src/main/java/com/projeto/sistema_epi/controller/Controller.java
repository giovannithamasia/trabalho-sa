package com.projeto.sistema_epi.controller;

import com.projeto.sistema_epi.dto.ColaboradorResponseDto;
import com.projeto.sistema_epi.dto.EmprestimoResponseDto;
import com.projeto.sistema_epi.dto.EpiResponseDto;
import com.projeto.sistema_epi.menu.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;



@Component
@RequiredArgsConstructor
public class Controller  implements CommandLineRunner {

    private final ColaboradorController colaboradorController;

    private final EmprestimoController emprestimoController;

    private final EpiController epiController;

    private final Menu menu = new Menu();

    private final Scanner sc = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {

        int opcao = 0;

        while (opcao!=12){
            menu.imprimirMenu();


            opcao = sc.nextInt();

            try {
                switch (opcao) {
                    case 1:
                        colaboradorController.cadastrar();
                        break;
                    case 2:
                        for (ColaboradorResponseDto c:colaboradorController.listar()){
                            System.out.println(c);
                        }
                        break;
                    case 3:
                        colaboradorController.atualizar();
                        break;
                    case 4:
                        colaboradorController.deletar();
                        break;
                    case 5:
                        epiController.cadastrarEpi();
                        break;
                    case 6:
                        for (EpiResponseDto e:epiController.listar()){
                            System.out.println(e);
                        }
                        break;
                    case 7:
                        epiController.atualizar();
                        break;
                    case 8:
                        epiController.deletar();
                        break;
                    case 9:
                        emprestimoController.retirarEpi();
                        break;
                    case 10:
                        emprestimoController.devolverEpi();
                        break;
                    case 11:
                        for (EmprestimoResponseDto e: emprestimoController.listarEmprestimos()){
                            System.out.println(e);
                        }
                        break;
                    case 12:
                        System.out.println("Encerrando programa...");
                        break;
                    default:
                        System.out.println("Opção Invalida! Tente Novamente");
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }


    }
}
