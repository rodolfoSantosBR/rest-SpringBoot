package com.example.abstractfactory_criacional.bancoBrasil;

import com.example.abstractfactory_criacional.Juros;

public class BBJuros implements Juros {
    @Override
    public double getJuros() {
        return 3;
    }
}