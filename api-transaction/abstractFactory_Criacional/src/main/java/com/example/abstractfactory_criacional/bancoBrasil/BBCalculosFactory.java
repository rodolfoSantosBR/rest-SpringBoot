package com.example.abstractfactory_criacional.bancoBrasil;

import com.example.abstractfactory_criacional.CalculosFactory;
import com.example.abstractfactory_criacional.Desconto;
import com.example.abstractfactory_criacional.Juros;
import com.example.abstractfactory_criacional.Multa;

public class BBCalculosFactory implements CalculosFactory {

    @Override
    public Juros criarJuros() {
        return new BBJuros();
    }
    @Override
    public Multa criarMulta() {
        return new BBMulta();
    }
    @Override
    public Desconto criarDesconto() {
        return new BBDesconto();
    }
}
