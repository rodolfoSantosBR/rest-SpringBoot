package com.example.factorymethod.bancoBrasil;

import com.example.factorymethod.banco.Boleto;

public class BancoBrasilCaixaBoleto30Dias extends Boleto {


    public BancoBrasilCaixaBoleto30Dias(double valor) {
        super(valor);
        this.juros = 0.05;
        this.desconto = 0.02;
        this.multa = 0.5;
    }
}
