package com.example.abstractfactory_criacional.bancoBrasil;

import com.example.abstractfactory_criacional.Multa;

public class BBMulta implements Multa {

    @Override
    public double getMulta() {
        return 3;
    }
}