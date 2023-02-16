package com.example.factorymethod.caixa;

import com.example.factorymethod.banco.Boleto;

public class BancoCaixaBoleto10Dias extends Boleto {

    public BancoCaixaBoleto10Dias(double valor) {

        super(valor);
        this.juros = 0.02;
        this.desconto = 0.02;
        this.multa = 0.1;
    }
}
