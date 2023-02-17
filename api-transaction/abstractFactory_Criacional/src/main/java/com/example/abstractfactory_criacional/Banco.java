package com.example.abstractfactory_criacional;

public class Banco {


    public Boleto gerarBoleto(double valor, CalculosFactory calculosFactory) {

        Boleto boleto = new Boleto(valor, calculosFactory);

        System.out.println("Boleto gerado com sucesso no valor : " + valor);

        System.out.println(boleto.calcularJuros());

        System.out.println(boleto.calcularDesconto());

        System.out.println(boleto.calcularMulta());

        return boleto ;

    }

}
