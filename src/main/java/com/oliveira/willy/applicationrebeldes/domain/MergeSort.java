package com.oliveira.willy.applicationrebeldes.domain;

import com.oliveira.willy.applicationrebeldes.enums.ParametroOrdenacao;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
public class MergeSort {
    private ParametroOrdenacao parametroOrdenacao;

    private List<Rebelde> merge(List<Rebelde> esquerda, List<Rebelde> direita) {
        ArrayList<Rebelde> arrayAuxiliar = new ArrayList<>();
        int esquerdaSize = esquerda.size();
        int direitaSize = direita.size();

        switch (parametroOrdenacao) {
            case NOME:
                while (esquerdaSize != 0 && direitaSize != 0) {
                    if (esquerda.get(0).getNome().compareTo(direita.get(0).getNome()) < 0) {
                        arrayAuxiliar.add(esquerda.remove(0));
                        esquerdaSize--;
                    } else {
                        arrayAuxiliar.add(direita.remove(0));
                        direitaSize--;
                    }
                }
                break;
            case IDADE:
                while (esquerdaSize != 0 && direitaSize != 0) {
                    if (esquerda.get(0).getIdade() < direita.get(0).getIdade()) {
                        arrayAuxiliar.add(esquerda.remove(0));
                        esquerdaSize--;
                    } else {
                        arrayAuxiliar.add(direita.remove(0));
                        direitaSize--;
                    }
                }
                break;
            case RACA:
                while (esquerdaSize != 0 && direitaSize != 0) {
                    if (esquerda.get(0).getRaca().compareTo(direita.get(0).getRaca()) < 0) {
                        arrayAuxiliar.add(esquerda.remove(0));
                        esquerdaSize--;
                    } else {
                        arrayAuxiliar.add(direita.remove(0));
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

    public List<Rebelde> mergeSort(List<Rebelde> rebeldes) {

        if (rebeldes == null) {
            return rebeldes;
        }

        if (rebeldes.size() <= 1) {
            return rebeldes;
        }

        int metadeLista = (int) Math.floor(rebeldes.size() / 2);

        List<Rebelde> metadeEsquerda = new ArrayList<>(rebeldes.subList(0, metadeLista));
        List<Rebelde> metadeDireita = new ArrayList<>(rebeldes.subList(metadeLista, rebeldes.size()));
        return merge(mergeSort(metadeEsquerda), mergeSort(metadeDireita));
    }

}
