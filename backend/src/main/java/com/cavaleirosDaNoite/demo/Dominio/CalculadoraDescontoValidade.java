package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Desconto.DescontoStrategy;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Validade.ValidadeStrategy;

public class CalculadoraDescontoValidade {
    private DescontoStrategy descontoStrategy;
    private ValidadeStrategy validadeStrategy;

    public CalculadoraDescontoValidade(DescontoStrategy descontoStrategy, ValidadeStrategy validadeStrategy) {
        this.descontoStrategy = descontoStrategy;
        this.validadeStrategy = validadeStrategy;
    }

    public double calcularDesconto(double valor, Cliente cliente) {
        return descontoStrategy.calcularDesconto(valor, cliente);
    }

    public int calcularPrazoValidade(boolean periodoBaixaProcura) {
        return validadeStrategy.calcularPrazoValidade(periodoBaixaProcura);
    }
}
