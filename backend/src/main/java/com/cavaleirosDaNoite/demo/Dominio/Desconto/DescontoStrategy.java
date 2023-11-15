package com.cavaleirosDaNoite.demo.Dominio.Desconto;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;

public interface DescontoStrategy {
    double calcularDesconto(double valor, Cliente cliente);
}
