package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoOrcamento {

    CalculadoraDescontoValidade calculadora;
    RepPedidos repPedidos;
    RepOrcamentos repOrcamentos;

    @Autowired
    public ServicoOrcamento(CalculadoraDescontoValidade calculadora, RepPedidos repPedidos,
            RepOrcamentos repOrcamentos) {
        this.calculadora = calculadora;
        this.repPedidos = repPedidos;
        this.repOrcamentos = repOrcamentos;
    }
    
    public Orcamento solicitarOrcamento(long idPedido){
        Pedido pedido = repPedidos.findById(idPedido).orElse(null);
        Cliente cliente = pedido.getCliente();
        double imposto = 0.10;
        double valorPedido = calcularSomatorioItensPedido(pedido.getId());
        double desconto = calculadora.calcularDesconto(valorPedido, cliente);
        double valorFinal = valorPedido - (valorPedido * imposto) - desconto;
        LocalDate data = LocalDate.now();
        Orcamento orcamento = new Orcamento();
        orcamento.setValorTotal(valorPedido);
        orcamento.setCliente(cliente);
        orcamento.setPedido(pedido);
        orcamento.setData(LocalDate.now());
        orcamento.setImposto(imposto);
        orcamento.setDesconto(desconto);
        orcamento.setEfetivado(false);
        return repOrcamentos.save(orcamento);
    }

    public double calcularSomatorioItensPedido(long id) {
        Pedido pedido = repPedidos.findById(id).orElse(null);
        double somatorio = pedido.getItens().stream().mapToDouble(ItemPedido::getValor).sum();
        return somatorio;
    }

    public List<Orcamento> orcamentosVencidos() {
        List<Orcamento> orcamentos = repOrcamentos.findAll();
        return orcamentos.stream()
                .filter(orcamento -> calculadora.calcularPrazoValidade(orcamento).isBefore(LocalDate.now()))
                .collect(Collectors.toList());

    }

    public List<Orcamento> orcamentosValidos() {
        List<Orcamento> orcamentos = repOrcamentos.findAll();
        return orcamentos.stream()
                .filter(orcamento -> calculadora.calcularPrazoValidade(orcamento).isAfter(LocalDate.now()))
                .collect(Collectors.toList());

    }

    public List<Orcamento> orcamentosCliente(long idCliente) {
        return repOrcamentos.findByClienteId(idCliente);
    }

    public Orcamento buscarOrcamento(long id) {
        return repOrcamentos.findById(id).orElse(null);
    }

    public Orcamento efetivarOrcamento(long idOrcamento){
        Orcamento orcamento = repOrcamentos.findById(idOrcamento).orElse(null);
        orcamento.setEfetivado(true);
        repOrcamentos.save(orcamento);
        return orcamento;
    }

    public List<Orcamento> listarOrcamentos() {
        return repOrcamentos.findAll();
    }

}
