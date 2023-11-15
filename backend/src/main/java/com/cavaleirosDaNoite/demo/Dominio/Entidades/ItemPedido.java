package com.cavaleirosDaNoite.demo.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity(name = "ItemPedidos")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    @JsonManagedReference
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    @JsonManagedReference
    private Produto produto;

    private int quantidade;

    public ItemPedido(long id, Pedido pedido, Produto produto, int quantidade) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    protected ItemPedido() {
    }

    public long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getValor() {
        return produto.getValor();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }



}
