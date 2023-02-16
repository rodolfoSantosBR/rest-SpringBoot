package com.example.factorymethod.bancoBrasil;

import com.example.factorymethod.banco.Boleto;

public class BancoBrasilCaixaBoleto60Dias extends Boleto {


    public BancoBrasilCaixaBoleto60Dias(double valor) {
        super(valor);
        this.juros = 0.10;
        this.desconto = 0;
        this.multa = 0.15;
    }
}
