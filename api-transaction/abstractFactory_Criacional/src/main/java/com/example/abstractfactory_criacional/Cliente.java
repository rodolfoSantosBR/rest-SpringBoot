package com.example.abstractfactory_criacional;

import com.example.abstractfactory_criacional.bancoBrasil.BBCalculosFactory;
import com.example.abstractfactory_criacional.caixa.CaixaCalculosFactory;

public class Cliente {

    public static void main(String[] args) {

    Banco banco = new Banco();

    banco.gerarBoleto(100, new BBCalculosFactory());

    banco.gerarBoleto(200, new CaixaCalculosFactory());

    }


}
