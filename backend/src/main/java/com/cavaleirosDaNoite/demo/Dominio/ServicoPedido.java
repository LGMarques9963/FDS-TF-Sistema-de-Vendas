package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoPedido {
    private final RepPedidos repPedidos;

    public ServicoPedido(RepPedidos repPedidos) {
        this.repPedidos = repPedidos;
    }

    public void cadastrarPedido(Pedido pedido) {
        repPedidos.save(pedido);
    }

    public void removerPedido(long id) {
        repPedidos.deleteById(id);
    }

    public Pedido buscarPedido(long id) {
        return repPedidos.findById(id).orElse(null);
    }

    public List<Pedido> listarPedidos() {
        return repPedidos.findAll();
    }

    public List<Pedido> buscarPedidoCliente(long idCliente) {
        return repPedidos.findByClienteId(idCliente);
    }

    public double calcularSomatorioItensPedido(long id){
        Pedido pedido = repPedidos.findById(id).orElse(null);
        double somatorio = pedido.getItens().stream().mapToDouble(ItemPedido::getValor).sum();
        return somatorio;
    }
}
