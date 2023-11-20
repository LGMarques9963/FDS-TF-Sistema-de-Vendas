package com.cavaleirosDaNoite.demo.Dominio.Repositorios;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces.IRepOrcamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import java.util.List;

@Repository
public class RepOrcamentos {
    private final IRepOrcamento orcamentoRepository;

    // Injeção de dependência do IRepOrcamentos

    @Autowired
    public RepOrcamentos(IRepOrcamento orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    // Adicione outras consultas conforme necessário OrcamentoRepository
    public List<Orcamento> findAll() {
        return (List<Orcamento>) orcamentoRepository.findAll();
    }
    public Optional<Orcamento> findById(long id) { // Procurar pela Id

        return orcamentoRepository.findById(id);
    }

    public List<Orcamento> findByClienteId(long idCliente) {  // Procurar pela Id do cliente
        return orcamentoRepository.findByClienteId(idCliente);
    }

    public Orcamento save(Orcamento orcamento) {
        return orcamentoRepository.save(orcamento);
    }
}