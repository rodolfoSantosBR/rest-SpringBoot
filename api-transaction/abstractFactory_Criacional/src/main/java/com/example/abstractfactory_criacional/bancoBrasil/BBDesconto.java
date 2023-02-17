package com.example.abstractfactory_criacional.bancoBrasil;

import com.example.abstractfactory_criacional.Desconto;

public class BBDesconto implements Desconto {
    @Override
    public double getDesconto() {
        return 3;
    }
}
