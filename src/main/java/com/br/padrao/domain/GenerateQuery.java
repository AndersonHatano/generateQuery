package com.br.padrao.domain;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class GenerateQuery {

    String table;
    List <String> Values;
    List <String> Operators;
    List <String> Comparators;

}
