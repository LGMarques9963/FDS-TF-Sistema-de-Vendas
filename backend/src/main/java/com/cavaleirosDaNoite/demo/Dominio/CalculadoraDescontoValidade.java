package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Desconto.DescontoStrategy;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.Validade.ValidadeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CalculadoraDescontoValidade {
    private final DescontoStrategy descontoNumeroComprasStrategy;
    private final DescontoStrategy descontoValorMedioStrategy;
    private final ValidadeStrategy validadeStrategy;

    @Autowired
    public CalculadoraDescontoValidade(
            @Qualifier("descontoNumeroComprasStrategy") DescontoStrategy descontoNumeroComprasStrategy,
            @Qualifier("descontoValorMedioStrategy") DescontoStrategy descontoValorMedioStrategy,
            ValidadeStrategy validadeStrategy) {
        this.descontoNumeroComprasStrategy = descontoNumeroComprasStrategy;
        this.descontoValorMedioStrategy = descontoValorMedioStrategy;
        this.validadeStrategy = validadeStrategy;
    }

    public double calcularDesconto(double valor, Cliente cliente) {
        return Math.max(
                descontoNumeroComprasStrategy.calcularDesconto(valor, cliente),
                descontoValorMedioStrategy.calcularDesconto(valor, cliente)
        );
    }

    public LocalDate calcularPrazoValidade(Orcamento orcamento) {
        return validadeStrategy.calcularPrazoValidade(orcamento);
    }
}
