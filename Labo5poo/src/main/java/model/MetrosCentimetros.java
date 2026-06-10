package model;

import patterns.strategy.EstrategiaConversion;

public class MetrosCentimetros implements EstrategiaConversion {

    @Override
    public double convertir(double valor) {
        return valor * 100;
    }
}