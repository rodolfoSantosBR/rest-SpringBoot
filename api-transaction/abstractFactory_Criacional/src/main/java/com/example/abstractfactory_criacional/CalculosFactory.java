package com.example.abstractfactory_criacional;

public interface CalculosFactory {

    Juros criarJuros() ;
    Multa criarMulta();
    Desconto criarDesconto();

}
