package com.cavaleirosDaNoite.demo.Dominio.Entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<ItemPedido> itens;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonBackReference
    private Cliente cliente;

    public Pedido(Date data, Cliente cliente, List<ItemPedido> itens) {
        this.data = data;
        this.cliente = cliente;
        this.itens = (itens != null) ? itens : new ArrayList<>();
    }

    protected Pedido() {
        this.itens = new ArrayList<>();
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setItens(List<ItemPedido> itensPedido) {
        this.itens = itensPedido;
    }

    public void updateItens(List<ItemPedido> itensPedido) {
        if (this.itens == null) { this.setItens(new ArrayList<>()); }
        this.itens.clear();
        this.itens.addAll(itensPedido);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void clearItens() {
        this.itens.clear();
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", data=" + data +
                ", itens=" + itens +
                ", cliente=" + cliente +
                '}';
    }
}
