package com.cavaleirosDaNoite.demo.Aplicacao;
import java.util.List;

public class PedidoRequest {
    private Long idCliente;
    private List<ItemPedidoRequest> itens;

    public PedidoRequest(Long idCliente, List<ItemPedidoRequest> itens) {
        this.idCliente = idCliente;
        this.itens = itens;
    }

    public PedidoRequest() {
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public List<ItemPedidoRequest> getItens() {
        return itens;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setItens(List<ItemPedidoRequest> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "PedidoRequest{" +
                "idCliente=" + idCliente +
                ", itens=" + itens +
                '}';
    }
}
