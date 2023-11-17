package com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface IRepOrcamento extends CrudRepository<Orcamento, Long> {

    List<Orcamento> findByClienteId(long idCliente);


}
