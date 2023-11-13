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

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidade;
    private long idProduto;


    public Estoque(long id, int quantidade, long idProduto) {
        this.id = id;
        this.quantidade = quantidade;
        this.idProduto = idProduto;
    }
    
    protected Estoque() {
    }

    public long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public long getIdProduto() {
        return idProduto;
    }

    @Override
    public String toString() {
        return "Estoque [id=" + id + ", quantidade=" + quantidade + ", idProduto=" + idProduto + "]";
    }


}
