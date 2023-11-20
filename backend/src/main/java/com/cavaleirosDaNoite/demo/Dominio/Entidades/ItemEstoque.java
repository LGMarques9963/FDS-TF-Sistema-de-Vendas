package com.cavaleirosDaNoite.demo.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity(name = "ItemEstoque")
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "idEstoque")
    @JsonBackReference
    private Estoque estoque;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    @JsonBackReference
    private Produto produto;

    private int quantidadeMax;

    private int quantidadeAtual;

    public ItemEstoque(Estoque estoque, Produto produto, int quantidadeAtual, int quantidadeMax) {
        this.estoque = estoque;
        this.produto = produto;
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMax = quantidadeMax;
    }

    protected ItemEstoque() {
    }

    public long getId() {
        return id;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public int getQuantidadeMax() {
        return quantidadeMax;
    }

    @Override
    public String toString() {
        String retorno = "ItemEstoque [id=" + id + ", estoque=" + estoque + ", produto=" + produto + ", quantidade atual="
                + quantidadeAtual + ", quantidade maxima=" + quantidadeMax +"]";
        return retorno;
    }


    
}
