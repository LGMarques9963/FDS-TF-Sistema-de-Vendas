package com.cavaleirosDaNoite.demo.Dominio.Repositorios;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces.IRepItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepItemPedido {
    private final IRepItemPedido itemPedidoRepository;

    @Autowired
    public RepItemPedido(IRepItemPedido itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public ItemPedido save(ItemPedido itemPedido) {
        itemPedidoRepository.save(itemPedido);
        return itemPedido;
    }

    public void deleteById(long id) {
        itemPedidoRepository.deleteById(id);
    }

    public ItemPedido findById(long id) {
        return itemPedidoRepository.findById(id).get();
    }

    public Iterable<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }




}
