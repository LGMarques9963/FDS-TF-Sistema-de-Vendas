package com.cavaleirosDaNoite.demo.Persistencia.dao;

import org.springframework.data.repository.CrudRepository;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;

public interface IRepPedido extends CrudRepository<Pedido, Long> {

}
