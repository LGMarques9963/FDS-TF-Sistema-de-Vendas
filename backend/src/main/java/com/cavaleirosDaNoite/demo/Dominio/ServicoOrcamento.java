package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;

import org.springframework.beans.factory.annotation.Autowired;

import com.cavaleirosDaNoite.demo.Dominio.CalculadoraDescontoValidade;

public class ServicoOrcamento { 

    CalculadoraDescontoValidade calculadora;
    PedidoService pedidoService;
    RepOrcamentos repOrcamentos;
    
    @Autowired
    public ServicoOrcamento(CalculadoraDescontoValidade calculadora, PedidoService pedidoService, RepOrcamentos repOrcamentos) {
        this.calculadora = calculadora;
        this.pedidoService = pedidoService;
        this.repOrcamentos = repOrcamentos;
    }
    
    public Orcamento solicitarOrcamento(Pedido pedido, Cliente cliente){
        double imposto = 0.10;
        double valorPedido = pedidoService.calcularSomatorioItensPedido(pedido.getId()); 
        double desconto = calculadora.calcularDesconto(valorPedido, cliente);
        double valorFinal = valorPedido - (valorPedido * imposto) - desconto;

        Orcamento orcamento = new Orcamento(valorFinal, pedido, cliente);
        return repOrcamentos.save(orcamento);



    }
    
}
 