package com.cavaleirosDaNoite.demo.Dominio.ServicoEstatisticas;

import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepClientes;
import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepOrcamentos;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public List<Cliente> clientesInadimplentes() {
        return reporcamentos.findAll().stream()
                .filter(orcamento -> !orcamento.isEfetivado())
                .map(Orcamento::getCliente)
                .distinct()
                .collect(Collectors.toList());
    }

}
