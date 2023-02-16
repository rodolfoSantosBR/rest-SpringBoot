package com.example.factorymethod.caixa;

import com.example.factorymethod.banco.Boleto;

public class BancoCaixaBoleto60Dias extends Boleto {


    public BancoCaixaBoleto60Dias(double valor) {
        super(valor);
        this.juros = 0.10;
        this.desconto = 10;
        this.multa = 0.2;
    }
}
