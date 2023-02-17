package com.example.abstractfactory_criacional;

public class Boleto {

    protected double valor ;
    protected Juros juros ;
    protected Desconto desconto ;
    protected Multa multa ;


    public Boleto(double valor, CalculosFactory calculosFactory) {
        this.valor = valor;

        this.juros = calculosFactory.criarJuros();
        this.multa = calculosFactory.criarMulta();
        this.desconto =  calculosFactory.criarDesconto();

    }

    public double calcularJuros() {
        return this.valor *  juros.getJuros();
    }
    public double calcularDesconto() {
        return this.valor *  desconto.getDesconto() ;
    }
    public double calcularMulta() {
        return this.valor *  multa.getMulta();
    }


}
