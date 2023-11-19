package com.cavaleirosDaNoite.demo.Dominio.Entidades;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemEstoque> itemEstoque;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemPedido> itensPedido;

    public Produto(long id, String nome, String descricao, double valor, List<ItemEstoque> itemEstoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.itemEstoque = (itemEstoque != null) ? itemEstoque : new ArrayList<>();
    }

    public Produto(String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    protected Produto() {
        this.itemEstoque = new ArrayList<>();
        this.itensPedido = new ArrayList<>();
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

    public List<ItemEstoque> getItemEstoque(){
        return itemEstoque;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public void setItemEstoque(List<ItemEstoque> itemEstoque){
        this.itemEstoque = itemEstoque;
    }

    public void setItensPedido(List<ItemPedido> itensPedido){
        this.itensPedido = itensPedido;
    }

    public List<ItemPedido> getItensPedido(){
        return itensPedido;
    }

    public void adicionarItemPedido(ItemPedido itemPedido){
        if (itensPedido == null){
            this.setItensPedido(new ArrayList<>());
        }
        itensPedido.add(itemPedido);
        itemPedido.setProduto(this);
    }

    public void adicionarItemEstoque(ItemEstoque itemEstoque){
        if (this.itemEstoque == null){
            this.setItemEstoque(new ArrayList<>());
        }
        this.itemEstoque.add(itemEstoque);
        itemEstoque.setProduto(this);
    }

    public void updateItemEstoque(List<ItemEstoque> itemEstoque){
        if (this.itemEstoque == null){
            this.setItemEstoque(new ArrayList<>());
        }
        this.itemEstoque.clear();
        this.itemEstoque.addAll(itemEstoque);
    }

    public void removerItemPedido(ItemPedido itemPedido){
        itensPedido.remove(itemPedido);
        itemPedido.setProduto(null);
    }

    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + "]";
    }

}