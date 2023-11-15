package com.cavaleirosDaNoite.demo.Dominio.Entidades;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


@Entity(name = "Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    @JsonManagedReference
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonManagedReference
    private Cliente cliente;

    public Pedido(long id, Date data, Produto produto, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.produto = produto;
        this.cliente = cliente;
    }

    protected Pedido() {
    }

    public long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }


    public Produto getProduto() {
        return produto;
    }


    public Cliente getCliente() {
        return cliente;
    }
    
}
