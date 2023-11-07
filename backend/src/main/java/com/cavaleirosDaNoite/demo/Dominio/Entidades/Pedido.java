package br.com.cavaleirosDaNoite.Dominio.Entidades;

import javax.annotation.processing.Generated;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;
    private double valorTotal;
    private long idProduto;
    private long idOrcamento;
    private long idCliente;

    public Pedido(long id, Date data, double valorTotal, long idProduto, long idOrcamento, long idCliente) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.idProduto = idProduto;
        this.idOrcamento = idOrcamento;
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

    public double getValorTotal() {
        return valorTotal;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public long getIdOrcamento() {
        return idOrcamento;
    }

    public long getIdCliente() {
        return idCliente;
    }
    
}
