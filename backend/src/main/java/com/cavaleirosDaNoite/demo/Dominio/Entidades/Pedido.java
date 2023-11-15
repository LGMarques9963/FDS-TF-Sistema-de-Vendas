package com.cavaleirosDaNoite.demo.Dominio.Entidades;

import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;


@Entity(name = "Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;
    private long idProduto;
    private long idCliente;

    public Pedido(long id, Date data, long idProduto, long idCliente) {
        this.id = id;
        this.data = data;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
    }

    protected Pedido() {
    }

    public long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }


    public long getIdProduto() {
        return idProduto;
    }


    public long getIdCliente() {
        return idCliente;
    }
    
}
