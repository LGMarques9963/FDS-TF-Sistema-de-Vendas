package com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces;

import org.springframework.data.repository.CrudRepository;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;

import java.util.List;

public interface IRepPedido extends CrudRepository<Pedido, Long> {

    List<Pedido> findByClienteId(long idCliente);
}
