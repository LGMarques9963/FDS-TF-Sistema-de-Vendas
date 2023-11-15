package com.cavaleirosDaNoite.demo.Dominio.Validade;

public class ValidadePeriodoBaixaProcuraStrategy implements ValidadeStrategy {
    public int calcularPrazoValidade(boolean periodoBaixaProcura) {
        if (periodoBaixaProcura){
            return 35;
        }else{
            return 21;
        }
    }
}
