package com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import org.springframework.data.repository.CrudRepository;

public interface IRepItemPedido extends CrudRepository<ItemPedido, Long> {
}
