package com.example.factorymethod.caixa;

import com.example.factorymethod.banco.Boleto;

public class BancoCaixaBoleto30Dias extends Boleto {


    public BancoCaixaBoleto30Dias(double valor) {
        super(valor);
        this.juros = 0.05;
        this.desconto = 0.05;
        this.multa = 0.1;
    }
}
