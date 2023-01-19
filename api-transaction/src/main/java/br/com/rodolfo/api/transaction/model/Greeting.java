package br.com.rodolfo.api.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Greeting {

    private final long id ;
    private final String content ;





}
