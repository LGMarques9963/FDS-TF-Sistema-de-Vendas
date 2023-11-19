package com.cavaleirosDaNoite.demo.Dominio.Servicos;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;
import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepItemPedido;
import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoItemPedido {
    RepItemPedido repItemPedido;

    RepPedidos repPedidos;

    @Autowired
    public ServicoItemPedido(RepItemPedido repItemPedido, RepPedidos repPedido) {
        this.repItemPedido = repItemPedido;
        this.repPedidos = repPedido;
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

    public double calcularSomatorioItensPedido(long id) {
        Pedido pedido = repPedidos.findById(id).orElse(null);
        if (pedido == null) {
            return 0;
        }
        return pedido.getItens().stream().mapToDouble(itemPedido -> itemPedido.getValor() * itemPedido.getQuantidade())
                .sum();
    }
}
