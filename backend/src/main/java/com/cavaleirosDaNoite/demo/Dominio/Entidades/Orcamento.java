package com.cavaleirosDaNoite.demo.Dominio.Entidades;

import java.time.LocalDate;
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
    private LocalDate data;
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


    public Orcamento(long id, double valorTotal, Cliente cliente, Pedido pedido, LocalDate data, double imposto,
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

    public Orcamento() {
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

    public LocalDate getData() {
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setValorTotal(double valorPedido) {
        this.valorTotal = valorPedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setData(LocalDate now) {
        this.data = now;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void setEfetivado(boolean b) {
        this.efetivado = b;
    }

    public String toString() {
        return "Orcamento{" + "id=" + id + ", valorTotal=" + valorTotal + ", cliente=" + cliente + ", pedido=" + pedido + ", data=" + data + ", imposto=" + imposto + ", desconto=" + desconto + ", efetivado=" + efetivado + '}';
    }
}
