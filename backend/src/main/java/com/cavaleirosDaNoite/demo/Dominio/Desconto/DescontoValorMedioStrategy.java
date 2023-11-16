package com.cavaleirosDaNoite.demo.Dominio.Desconto;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.RepOrcamentos;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DescontoValorMedioStrategy implements DescontoStrategy {
    private RepOrcamentos repOrcamentos;
    @Override
    public double calcularDesconto(double valor, Cliente cliente) {
        List<Orcamento> orcamentoList = repOrcamentos.findByClienteId(cliente.getId());

        if (orcamentoList.size() < 3) {
            return 0;
        }

        double valorMedio = orcamentoList.stream().sorted((o1, o2) -> o2.getData().compareTo(o1.getData()))
                .limit(3)
                .mapToDouble(Orcamento::getValorTotal)
                .average()
                .orElse(0);

        double desconto = 0.1;

        desconto += Math.min((int) (valorMedio - 10000) / 10000, 3) * 0.05;

        return Math.min(desconto, 0.3) * valor;
    }
}
