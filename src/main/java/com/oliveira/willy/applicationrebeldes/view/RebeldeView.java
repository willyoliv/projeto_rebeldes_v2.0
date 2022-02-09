package com.oliveira.willy.applicationrebeldes.view;

import com.oliveira.willy.applicationrebeldes.domain.Rebelde;
import com.oliveira.willy.applicationrebeldes.enums.Raca;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RebeldeView {
    private Rebelde rebelde;

    public Rebelde cadastrarRebelde() {
        this.rebelde = new Rebelde();
        System.out.println("#######---CADASTR0---#####");
        this.rebelde.setNome(perguntarNome());
        this.rebelde.setRaca(perguntarRaca());
        this.rebelde.setIdade(perguntarIdade());
        System.out.println();
        return this.rebelde;
    }

    private String perguntarNome() {
        System.out.println("#######---INFORME SEU NOME---#####");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        if (nome.isBlank()) {
            System.out.println("Por favor informe um valor não nulo ou vazio!");
            return perguntarNome();
        }
        return nome;
    }

    private Raca perguntarRaca() {
        List<Raca> listaDeRacas = Arrays.asList(Raca.values());
        System.out.println("#######---SELECIONE SUA RAÇA---#####");
        System.out.println("[UTILIZE O NÚMERO CORRESPONDENTE A OPÇÃO]");
        int index = 0;
        for (Raca raca : listaDeRacas) {
            System.out.printf("[%d] - %s. %n", index, raca);
            index++;
        }

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.next();

        switch (opcao) {
            case "0":
                return Raca.HUMANO;
            case "1":
                return Raca.GREE;
            case "2":
                return Raca.RAKATA;
            default:
                System.out.println("Opção inválida, por favor escolha uma opção válida do menu.");
                return perguntarRaca();
        }
    }

    private int perguntarIdade() {
        System.out.println("#######---INFORME SUA IDADE---#####");
        Scanner scanner = new Scanner(System.in);
        int idade;
        try {
            idade  = scanner.nextInt();
            return idade;
        } catch (InputMismatchException exception) {
            System.out.println("Idade inválida, por favor informe um valor numerico!");
            return perguntarIdade();
        }
    }
}
