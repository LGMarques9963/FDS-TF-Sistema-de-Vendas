package com.cavaleirosDaNoite.demo.Dominio.Servicos;

import com.cavaleirosDaNoite.demo.Dominio.CalculadoraDescontoValidade;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemEstoque;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;

import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepItemEstoque;
import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepOrcamentos;
import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepPedidos;
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
    RepItemEstoque repItemEstoque;
    ServicoItemPedido servicoItemPedido;

    @Autowired
    public ServicoOrcamento(CalculadoraDescontoValidade calculadora, RepPedidos repPedidos,
            RepOrcamentos repOrcamentos, ServicoItemPedido servicoItemPedido) {
        this.calculadora = calculadora;
        this.repPedidos = repPedidos;
        this.repOrcamentos = repOrcamentos;
        this.servicoItemPedido = servicoItemPedido;
    }
    
    public Orcamento solicitarOrcamento(long idPedido){
        Pedido pedido = repPedidos.findById(idPedido).orElse(null);
        if (pedido == null) {
            return null;
        }
        Cliente cliente = pedido.getCliente();
        double imposto = 0.10;
        double valorPedido = servicoItemPedido.calcularSomatorioItensPedido(pedido.getId());
        double desconto = calculadora.calcularDesconto(valorPedido, cliente);
        double valorFinal = valorPedido + (valorPedido * imposto) - desconto;
        LocalDate data = LocalDate.now();
        Orcamento orcamento = new Orcamento();
        orcamento.setValorTotal(valorFinal);
        orcamento.setCliente(cliente);
        orcamento.setPedido(pedido);
        orcamento.setData(data);
        orcamento.setImposto(imposto);
        orcamento.setDesconto(desconto);
        orcamento.setEfetivado(false);
        return repOrcamentos.save(orcamento);
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
        List<ItemPedido> itemPedido = orcamento.getPedido().getItens();
        List<Boolean> lista = itemPedido.stream().map(item -> {
            int qtdeEstoque = item.getProduto().getItemEstoque().stream().map(itemEstoque -> itemEstoque.getQuantidadeAtual()).findFirst().orElse(null);
            int qtdePedido = item.getQuantidade();
            return qtdeEstoque >= qtdePedido;
        }).collect(Collectors.toList());
        if (lista.contains(false)){
            throw new RuntimeException("Quantidade de produtos insuficiente no estoque");
        } else {
            itemPedido.stream().map(item -> {
                int qtdeEstoque = item.getProduto().getItemEstoque().stream().map(itemEstoque -> itemEstoque.getQuantidadeAtual()).findFirst().orElse(null);
                int qtdePedido = item.getQuantidade();
                int qtdeAtualizada = qtdeEstoque - qtdePedido;
                item.getProduto().getItemEstoque().forEach(itemEstoque -> {
                    itemEstoque.setQuantidadeAtual(qtdeAtualizada);
                    repItemEstoque.save(itemEstoque);
                });
                return null;
            });
            orcamento.setEfetivado(true);
            repOrcamentos.save(orcamento);
        }
        return orcamento;
    }

    public List<Orcamento> listarOrcamentos() {
        return repOrcamentos.findAll();
    }

}
