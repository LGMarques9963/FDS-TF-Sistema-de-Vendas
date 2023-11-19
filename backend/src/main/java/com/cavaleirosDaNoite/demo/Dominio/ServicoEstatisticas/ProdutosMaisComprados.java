package com.cavaleirosDaNoite.demo.Dominio.ServicoEstatisticas;

import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepOrcamentos;
import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepProdutos;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

@Service
public class ProdutosMaisComprados {

    RepProdutos repProdutos;
    RepOrcamentos repOrcamentos;

    @Autowired
    public ProdutosMaisComprados(RepProdutos repProdutos, RepOrcamentos repOrcamentos) {
        this.repOrcamentos = repOrcamentos;
        this.repProdutos = repProdutos;
    }

    public List<Produto> produtosMaisComprados() {
        Map<Produto, Integer> produtosMaisComprados = new HashMap<>();

        repOrcamentos.findAll().stream()
                .filter(Orcamento::isEfetivado)
                .map(Orcamento::getPedido)
                .flatMap(pedido -> pedido.getItens().stream())
                .forEach(itemPedido -> produtosMaisComprados.merge(itemPedido.getProduto(),
                        itemPedido.getQuantidade(),
                        Integer::sum));

        return produtosMaisComprados.entrySet().stream()
                .sorted(Map.Entry.<Produto, Integer>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
