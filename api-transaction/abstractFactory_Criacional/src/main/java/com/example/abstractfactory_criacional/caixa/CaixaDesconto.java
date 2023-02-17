package com.example.abstractfactory_criacional.caixa;

import com.example.abstractfactory_criacional.Desconto;

public class CaixaDesconto implements Desconto {
    @Override
    public double getDesconto() {
        return 0;
    }

}
