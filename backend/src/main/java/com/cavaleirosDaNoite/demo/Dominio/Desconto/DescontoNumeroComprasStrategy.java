package com.cavaleirosDaNoite.demo.Dominio.Desconto;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepOrcamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DescontoNumeroComprasStrategy implements DescontoStrategy {
    @Autowired
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
