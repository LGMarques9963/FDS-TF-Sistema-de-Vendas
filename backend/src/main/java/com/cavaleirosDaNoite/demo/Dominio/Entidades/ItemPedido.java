package com.cavaleirosDaNoite.demo.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "ItemPedidos")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    @JsonBackReference
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    @JsonBackReference
    private Pedido pedido;

    private int quantidade;

    public ItemPedido(long id, Produto produto, int quantidade, Pedido pedido) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.pedido = pedido;
    }

    public ItemPedido(Produto produto, int quantidade, Pedido pedido) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.pedido = pedido;
        produto.adicionarItemPedido(this);
    }

    protected ItemPedido() {
    }

    public long getId() {
        return id;
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

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }


    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }
}
