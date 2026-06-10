package model;

import patterns.strategy.EstrategiaConversion;

public class Conversor {

    private EstrategiaConversion estrategia;

    public void setEstrategia(EstrategiaConversion estrategia) {
        this.estrategia = estrategia;
    }

    public double convertir(double valor) {
        return estrategia.convertir(valor);
    }
}

