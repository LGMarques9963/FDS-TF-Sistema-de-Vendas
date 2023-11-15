package com.cavaleirosDaNoite.demo.Dominio.Entidades;

import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity(name = "Orcamentos")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double valorTotal;
    private long idCliente;
    private long idPedido;
    private Date data;
    private double imposto;
    private double desconto;
    private boolean efetivado;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonManagedReference
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    @JsonManagedReference
    private Pedido pedido;


    public Orcamento(long id, double valorTotal, Cliente cliente, Pedido pedido, Date data, double imposto,
            double desconto, boolean efetivado) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.pedido = pedido;
        this.data = data;
        this.imposto = imposto;
        this.desconto = desconto;
        this.efetivado = efetivado;
    }

    protected Orcamento() {
    }

    public long getId() {
        return id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Date getData() {
        return data;
    }

    public double getImposto() {
        return imposto;
    }

    public double getDesconto() {
        return desconto;
    }

    public boolean isEfetivado() {
        return efetivado;
    }

}
