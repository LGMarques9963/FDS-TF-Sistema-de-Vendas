package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoItemPedido {
    RepItemPedido repItemPedido;

    @Autowired
    public ServicoItemPedido(RepItemPedido repItemPedido) {
        this.repItemPedido = repItemPedido;
    }

    public void cadastrarItemPedido(ItemPedido itemPedido) {
        repItemPedido.save(itemPedido);
    }

    public void removerItemPedido(long id) {
        repItemPedido.deleteById(id);
    }

    public ItemPedido buscarItemPedido(long id) {
        return repItemPedido.findById(id);
    }

    public ItemPedido atualizarItemPedido(ItemPedido itemPedido) {
        System.out.println("ItemPedido recebido: " + itemPedido.toString()  + " id: " + itemPedido.getId());
        return repItemPedido.save(itemPedido);
    }

    public List<ItemPedido> listarItemPedido() {
        return (List<ItemPedido>) repItemPedido.findAll();
    }
}
