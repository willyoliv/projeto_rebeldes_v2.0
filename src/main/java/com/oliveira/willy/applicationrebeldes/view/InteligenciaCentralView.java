package com.oliveira.willy.applicationrebeldes.view;

import com.oliveira.willy.applicationrebeldes.controller.InteligenciaCentral;
import com.oliveira.willy.applicationrebeldes.domain.Rebelde;
import com.oliveira.willy.applicationrebeldes.enums.ParametroOrdenacao;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class InteligenciaCentralView {
    private InteligenciaCentral inteligenciaCentral;
    private RebeldeView rebeldeView;

    public void exibirMenu() {
        System.out.println("#######---MENU---#####");
        System.out.println("[UTILIZE O NÚMERO CORRESPONDENTE A OPÇÃO]");
        System.out.println("[1] - CADASTRAR DADOS.");
        System.out.println("[0] - SAIR.");

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.next();

        switch (opcao) {
            case "1":
                Rebelde rebelde = this.rebeldeView.cadastrarRebelde();
                boolean solicitarAcesso = this.inteligenciaCentral.solicitarAcesso();
                if (solicitarAcesso) {
                    System.out.println("Acesso PERMITIDO. Bem-vindo novo Rebelde!");
                    this.inteligenciaCentral.cadastrarRebelde(rebelde);
                    menuSalvarLista();
                    this.inteligenciaCentral.salvarListaDeRebeldesEmArquivoTxt();
                    this.inteligenciaCentral.imprimirListaDeRebeldesConsole();
                    System.out.println("-----------------------------------------");
                    System.out.println("");
                } else {
                    System.out.println("Acesso NEGADO, você não é de confiança!");
                }
                exibirMenu();
                break;
            case "0":
                System.exit(0);
                scanner.close();
                break;
            default:
                System.out.println("Opção inválida, por favor escolha uma opção válida do menu.");
                exibirMenu();
        }
    }

    private void menuSalvarLista() {
        System.out.println("INFORME QUAL PARÂMETRO SERÁ UTILIZADO PARA ORDENAR A LISTA!");
        System.out.println("[UTILIZE O NÚMERO CORRESPONDENTE A OPÇÃO]");
        System.out.println("[1] - NOME.");
        System.out.println("[2] - IDADE.");
        System.out.println("[3] - RACA.");

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.next();

        switch (opcao) {
            case "1":
                this.inteligenciaCentral.ordernarLista(ParametroOrdenacao.NOME);
                break;
            case "2":
                this.inteligenciaCentral.ordernarLista(ParametroOrdenacao.IDADE);
                break;
            case "3":
                this.inteligenciaCentral.ordernarLista(ParametroOrdenacao.RACA);
                break;
            default:
                System.out.println("Opção inválida, por favor escolha uma opção válida do menu.");
                menuSalvarLista();
        }
    }
}
