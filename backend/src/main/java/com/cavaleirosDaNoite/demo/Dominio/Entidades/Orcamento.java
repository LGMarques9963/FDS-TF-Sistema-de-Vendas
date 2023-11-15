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

    public Orcamento(long id, double valorTotal, long idCliente, long idPedido, Date data, double imposto,
            double desconto, boolean efetivado) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.idCliente = idCliente;
        this.idPedido = idPedido;
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

    public long getIdCliente() {
        return idCliente;
    }

    public long getIdPedido() {
        return idPedido;
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

    public boolean getEfetivado() {
        return efetivado;
    }

}
