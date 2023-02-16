package com.example.factorymethod.bancoBrasil;

import com.example.factorymethod.banco.Boleto;

public class BancoBrasilCaixaBoleto10Dias extends Boleto {

    public BancoBrasilCaixaBoleto10Dias(double valor) {

        super(valor);
        this.juros = 0.02;
        this.desconto = 0.02;
        this.multa = 0.1;
    }
}
