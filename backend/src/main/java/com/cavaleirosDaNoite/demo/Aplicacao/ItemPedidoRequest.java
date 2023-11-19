package com.cavaleirosDaNoite.demo.Aplicacao;

public class ItemPedidoRequest {
    private Long idProduto;
    private int quantidade;

    public ItemPedidoRequest(Long idProduto, int quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public ItemPedidoRequest() {
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedidoRequest{" +
                "idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                '}';
    }
}
