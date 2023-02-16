package com.example.factorymethod;

import com.example.factorymethod.banco.Banco;
import com.example.factorymethod.bancoBrasil.BancoBrasil;
import com.example.factorymethod.caixa.BancoCaixa;

public class Cliente {

    public static void main(String[] args) {

        Banco banco = new BancoBrasil();

        try {
            banco.gerarBoleto(10,8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
