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
    private ItemEstoque itemEstoque;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemPedido> itensPedido;

    public Produto(long id, String nome, String descricao, double valor, ItemEstoque itemEstoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.itemEstoque = itemEstoque;
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

    public ItemEstoque getItemEstoque(){
        return itemEstoque;
    }

    public long getIdItemEstoque(){
        return itemEstoque.getId();
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

    public void setItemEstoquestoque(ItemEstoque itemEstoque){
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

    public void removerItemPedido(ItemPedido itemPedido){
        itensPedido.remove(itemPedido);
        itemPedido.setProduto(null);
    }


    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + ", ]";
    }


}