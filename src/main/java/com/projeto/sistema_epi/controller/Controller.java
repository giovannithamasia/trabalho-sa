package com.projeto.sistema_epi.controller;

import com.projeto.sistema_epi.menu.Menu;
import com.projeto.sistema_epi.service.ColaboradorService;
import com.projeto.sistema_epi.service.EmprestimoService;
import com.projeto.sistema_epi.service.EpiService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Scanner;


@Component
@RequiredArgsConstructor
public class Controller  implements CommandLineRunner {

    private final ColaboradorService colaboradorService;

    private final EpiService epiService;

    private final EmprestimoService emprestimoService;

    private  final Menu menu = new Menu();

    private final ColaboradorController colaboradorController;

    private final EpiController epiController;

    private final EmprestimoController emprestimoController;
    
    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);


        int opcao = 0;

        while(opcao!=12){
            menu.imprimirMenu();

            opcao = sc.nextInt();

            sc.nextLine();
            try {
                switch (opcao) {
                    case 1:
                      colaboradorController.cadastrar();
                      break;
                    case 2:
                        System.out.println(colaboradorService.listarColaboradores());
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
                        System.out.println(epiService.listarEPIs());
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
                        System.out.println("Informe o id do Emprestimo a ser devolvido: ");
                        Long idDevolvido = sc.nextLong();

                        emprestimoService.devolverEpi(idDevolvido);
                        break;
                    case 11:
                        System.out.println(emprestimoService.listarEmprestimos());
                        break;
                    case 12:
                        System.out.println("Encerrando programa");
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