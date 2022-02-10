package com.oliveira.willy.applicationrebeldes.domain;

import com.oliveira.willy.applicationrebeldes.enums.ParametroOrdenacao;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Setter
public class MergeSort {
    private ParametroOrdenacao parametroOrdenacao;

    private LinkedList<Rebelde> merge(LinkedList<Rebelde> esquerda, LinkedList<Rebelde> direita) {
        LinkedList<Rebelde> arrayAuxiliar = new LinkedList<>();
        int esquerdaSize = esquerda.size();
        int direitaSize = direita.size();

        switch (parametroOrdenacao) {
            case NOME:
                while (esquerdaSize != 0 && direitaSize != 0) {
                    if (esquerda.peek().getNome().compareTo(direita.peek().getNome()) < 0) {
                        arrayAuxiliar.add(esquerda.poll());
                        esquerdaSize--;
                    } else {
                        arrayAuxiliar.add(direita.poll());
                        direitaSize--;
                    }
                }
                break;
            case IDADE:
                while (esquerdaSize != 0 && direitaSize != 0) {
                    if (esquerda.peek().getIdade() < direita.peek().getIdade()) {
                        arrayAuxiliar.add(esquerda.poll());
                        esquerdaSize--;
                    } else {
                        arrayAuxiliar.add(direita.poll());
                        direitaSize--;
                    }
                }
                break;
            case RACA:
                while (esquerdaSize != 0 && direitaSize != 0) {
                    if (esquerda.peek().getRaca().compareTo(direita.peek().getRaca()) < 0) {
                        arrayAuxiliar.add(esquerda.poll());
                        esquerdaSize--;
                    } else {
                        arrayAuxiliar.add(direita.poll());
                        direitaSize--;
                    }
                }
                break;
        }


        if (esquerda.size() > 0) {
            arrayAuxiliar.addAll(esquerda);
        } else if (direita.size() > 0) {
            arrayAuxiliar.addAll(direita);
        }

        return  arrayAuxiliar;
    }

    public LinkedList<Rebelde> mergeSort(LinkedList<Rebelde> rebeldes) {

        if (rebeldes == null) {
            return rebeldes;
        }

        if (rebeldes.size() <= 1) {
            return rebeldes;
        }

        int metadeLista = (int) Math.floor(rebeldes.size() / 2);

        LinkedList<Rebelde> metadeEsquerda = new LinkedList<>(rebeldes.subList(0, metadeLista));
        LinkedList<Rebelde> metadeDireita = new LinkedList<>(rebeldes.subList(metadeLista, rebeldes.size()));
        return merge(mergeSort(metadeEsquerda), mergeSort(metadeDireita));
    }

}
