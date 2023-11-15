package com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces;

import org.springframework.data.repository.CrudRepository;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;

public interface IRepProdutos extends CrudRepository<Produto, Long> {

}
