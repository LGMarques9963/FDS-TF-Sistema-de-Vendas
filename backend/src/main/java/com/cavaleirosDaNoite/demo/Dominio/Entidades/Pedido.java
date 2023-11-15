package com.cavaleirosDaNoite.demo.Dominio.Entidades;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


@Entity(name = "Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemPedido> itens;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonManagedReference
    private Cliente cliente;

    public Pedido(Date data, Cliente cliente, List<ItemPedido> itens) {
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
    }

    protected Pedido() {
    }

    public long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }


    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        item.setPedido(this);
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
        item.setPedido(null);
    }


    public Cliente getCliente() {
        return cliente;
    }

}
