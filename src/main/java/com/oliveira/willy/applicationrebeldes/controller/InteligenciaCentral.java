package com.oliveira.willy.applicationrebeldes.controller;

import com.oliveira.willy.applicationrebeldes.domain.MergeSort;
import com.oliveira.willy.applicationrebeldes.domain.Rebelde;
import com.oliveira.willy.applicationrebeldes.enums.ParametroOrdenacao;
import lombok.Cleanup;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class InteligenciaCentral {
    private List<Rebelde> rebeldes = new ArrayList<>();


    public void cadastrarRebelde(Rebelde rebelde) {
        this.rebeldes.add(rebelde);
    }

    public boolean solicitarAcesso() {
        Random ran = new Random();
        boolean acessoLiberado = false;
        double numero = ran.nextDouble();
        if (numero > 0.5) {
            acessoLiberado = true;
        }
        return acessoLiberado;
    }
    public void ordernarLista(ParametroOrdenacao parametrosOrdenacao) {
        MergeSort mergeSorte = new MergeSort(parametrosOrdenacao);
        this.rebeldes = mergeSorte.mergeSort(this.rebeldes);
    }

    public void salvarListaDeRebeldesEmArquivoTxt() {
        try {
            @Cleanup PrintWriter writer = new PrintWriter("rebeldes.txt", "UTF-8");
            writer.println("REBELDES");
            writer.println("");
            int count = 0;
            for (Rebelde rebelde : rebeldes) {
                writer.println(count + " - "+ rebelde.toString());
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void imprimirListaDeRebeldesConsole() {
        for (Rebelde rebelde : rebeldes) {
            System.out.println(" - "+ rebelde.toString());
        }
    }
}
