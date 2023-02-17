package com.example.abstractfactory_criacional.caixa;

import com.example.abstractfactory_criacional.CalculosFactory;
import com.example.abstractfactory_criacional.Desconto;
import com.example.abstractfactory_criacional.Juros;
import com.example.abstractfactory_criacional.Multa;
import com.example.abstractfactory_criacional.bancoBrasil.BBDesconto;
import com.example.abstractfactory_criacional.bancoBrasil.BBJuros;
import com.example.abstractfactory_criacional.bancoBrasil.BBMulta;

public class CaixaCalculosFactory implements CalculosFactory {

    @Override
    public Juros criarJuros() {
        return new CaixaJuros();
    }
    @Override
    public Multa criarMulta() {
        return new CaixaMulta();
    }
    @Override
    public Desconto criarDesconto() {
        return new CaixaDesconto();
    }
}
