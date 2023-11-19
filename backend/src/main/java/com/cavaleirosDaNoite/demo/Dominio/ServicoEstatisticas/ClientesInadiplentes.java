package com.cavaleirosDaNoite.demo.Dominio.ServicoEstatisticas;

import com.cavaleirosDaNoite.demo.Dominio.RepClientes;
import com.cavaleirosDaNoite.demo.Dominio.RepOrcamentos;
import com.cavaleirosDaNoite.demo.Dominio.RepProdutos;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClientesInadiplentes {

    RepOrcamentos reporcamentos;
    RepClientes repClientes;

    @Autowired
    public ClientesInadiplentes(RepOrcamentos repOrcamentos, RepClientes repClientes) {
        this.reporcamentos = repOrcamentos;
        this.repClientes = repClientes;

    }

    public Map<Cliente, Long> clientesInadiplentes() {
        return reporcamentos.findAll().stream()
                .filter(orcamento -> !orcamento.isEfetivado())
                .collect(Collectors.groupingBy(Orcamento::getCliente, Collectors.counting()));
    }

}
