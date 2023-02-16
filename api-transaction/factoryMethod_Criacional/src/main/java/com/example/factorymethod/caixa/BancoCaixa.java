package com.example.factorymethod.caixa;

import com.example.factorymethod.banco.Boleto;
import com.example.factorymethod.banco.Banco;

public class BancoCaixa  extends Banco {


    @Override
    protected Boleto criarBoleto(int vencimentoBoleto, double valor) throws Exception {
        switch (vencimentoBoleto ) {

            case 10 : return new BancoCaixaBoleto10Dias(valor);

            case 30 : return new BancoCaixaBoleto30Dias(valor);

            case 60 : return new BancoCaixaBoleto60Dias(valor);

            default:
                throw new Exception("Vencimento nao disponivel");

        }
    }


}
