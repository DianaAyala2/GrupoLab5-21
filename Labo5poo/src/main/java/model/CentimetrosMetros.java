package model;

import patterns.strategy.EstrategiaConversion;

public class CentimetrosMetros implements EstrategiaConversion  {

        @Override
        public double convertir(double valor) {
            return valor * 0.01;
        }
}
