package com.cavaleirosDaNoite.demo.Dominio.Entidades;


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

@Entity(name = "Produtos")
public class Produto {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private double valor;
    private long idEstoque;

    public Produto(long id, String nome, String descricao, double valor, long idEstoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.idEstoque = idEstoque;
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

    public long getIdEstoque(){
        return idEstoque;
    }


    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + ", idEstoque=" + idEstoque + "]";
    }


}