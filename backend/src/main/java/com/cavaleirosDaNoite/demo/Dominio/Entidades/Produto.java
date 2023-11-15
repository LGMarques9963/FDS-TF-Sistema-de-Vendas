package com.cavaleirosDaNoite.demo.Dominio.Entidades;


import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity(name = "Produtos")
public class Produto {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "idEstoque")
    @JsonManagedReference
    private Estoque estoque;

    public Produto(long id, String nome, String descricao, double valor, Estoque estoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.estoque = estoque;
    }

    protected Produto() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public double getValor(){
        return valor;
    }

    public Estoque getEstoque(){
        return estoque;
    }


    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + ", idEstoque=" + estoque.getId() + "]";
    }


}