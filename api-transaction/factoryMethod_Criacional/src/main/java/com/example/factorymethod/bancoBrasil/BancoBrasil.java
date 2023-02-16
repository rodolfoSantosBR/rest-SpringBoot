package com.example.factorymethod.bancoBrasil;

import com.example.factorymethod.banco.Boleto;
import com.example.factorymethod.banco.Banco;

public class BancoBrasil extends Banco {

    @Override
    protected Boleto criarBoleto(int vencimentoBoleto, double valor) throws Exception {
        switch (vencimentoBoleto ) {

            case 10 : return new BancoBrasilCaixaBoleto10Dias(valor);

            case 30 : return new BancoBrasilCaixaBoleto10Dias(valor);

            case 60 : return new BancoBrasilCaixaBoleto10Dias(valor);

            default:
                throw new Exception("Vencimento nao disponivel");

        }
    }


}
