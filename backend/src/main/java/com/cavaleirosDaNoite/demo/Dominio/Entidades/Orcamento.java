package br.com.cavaleirosDaNoite.Dominio.Entidades;

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

public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double valorTotal;
    private long idCliente;
    private long idPedido;
    private date data;

    public Orcamento(long id, double valorTotal, long idCliente, long idPedido, date data) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.idCliente = idCliente;
        this.idPedido = idPedido;
        this.data = data;
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

    public date getData() {
        return data;
    }

}
