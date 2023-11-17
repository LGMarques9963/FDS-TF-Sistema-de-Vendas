package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Aplicacao.PedidoRequest;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class ServicoPedido {
    private final RepPedidos repPedidos;
    private final ServicoCliente servicoCliente;
    private final ServicoProduto servicoProduto;
    @Autowired
    public ServicoPedido(RepPedidos repPedidos, ServicoCliente servicoCliente, ServicoProduto servicoProduto) {
        this.repPedidos = repPedidos;
        this.servicoCliente = servicoCliente;
        this.servicoProduto = servicoProduto;
    }

    public Pedido cadastrarPedido(PedidoRequest pedidoRequest) {
        Date data = new Date();
        Cliente cliente = servicoCliente.buscarCliente(pedidoRequest.getIdCliente());
        List<ItemPedido> itensPedido = pedidoRequest.getItens().stream()
                .map(itemRequest-> new ItemPedido(
                        servicoProduto.buscarProduto(itemRequest.getIdProduto()),
                        itemRequest.getQuantidade()
                )).toList();
        System.out.println("Itens do pedido");
        System.out.println(itensPedido);
        Pedido pedido = new Pedido(data, cliente, itensPedido);
        return repPedidos.save(pedido);
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


}
