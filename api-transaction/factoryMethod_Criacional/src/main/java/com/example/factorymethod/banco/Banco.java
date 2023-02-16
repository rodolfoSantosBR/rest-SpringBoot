package com.example.factorymethod.banco;

public abstract class Banco {

    public Boleto gerarBoleto(int vencimentoBoleto, double valor ) throws Exception {

        Boleto boleto = this.criarBoleto(vencimentoBoleto, valor);

        return boleto ;
    }

    abstract protected Boleto criarBoleto( int vencimentoBoleto, double valor ) throws Exception;


}
