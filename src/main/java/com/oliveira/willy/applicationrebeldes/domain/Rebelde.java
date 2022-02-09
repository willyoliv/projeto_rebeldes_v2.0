package com.oliveira.willy.applicationrebeldes.domain;

import com.oliveira.willy.applicationrebeldes.enums.Raca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rebelde {
    private String nome;
    private Raca raca;
    private int idade;
}
