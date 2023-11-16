package com.cavaleirosDaNoite.demo.Dominio.Desconto;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.RepOrcamentos;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class DescontoNumeroComprasStrategy implements DescontoStrategy {
    private RepOrcamentos repOrcamentos;
    @Override
    public double calcularDesconto(double valor, Cliente cliente) {
        List<Orcamento> orcamentoList = repOrcamentos.findByClienteId(cliente.getId());

        int numeroCompras =orcamentoList.size();
        double desconto = 0;
        desconto = ((double) numeroCompras / 10 ) * 0.05;
        return Math.min(desconto, 0.3);

    }
}
