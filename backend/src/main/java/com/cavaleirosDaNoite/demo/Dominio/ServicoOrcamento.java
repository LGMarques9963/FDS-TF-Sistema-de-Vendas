package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;

import org.springframework.beans.factory.annotation.Autowired;

import com.cavaleirosDaNoite.demo.Dominio.CalculadoraDescontoValidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class ServicoOrcamento { 

    CalculadoraDescontoValidade calculadora;
    ServicoPedido pedidoService;
    RepOrcamentos repOrcamentos;
    
    @Autowired
    public ServicoOrcamento(CalculadoraDescontoValidade calculadora, ServicoPedido pedidoService, RepOrcamentos repOrcamentos) {
        this.calculadora = calculadora;
        this.pedidoService = pedidoService;
        this.repOrcamentos = repOrcamentos;
    }
    
    public Orcamento solicitarOrcamento(Pedido pedido, Cliente cliente){
        double imposto = 0.10;
        double valorPedido = pedidoService.calcularSomatorioItensPedido(pedido.getId()); 
        double desconto = calculadora.calcularDesconto(valorPedido, cliente);
        double valorFinal = valorPedido - (valorPedido * imposto) - desconto;
        LocalDate data = LocalDate.now();

        return repOrcamentos.save(orcamento);



    }
    
}
 