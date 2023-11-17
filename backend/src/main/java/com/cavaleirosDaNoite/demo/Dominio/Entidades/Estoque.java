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

@Entity(name = "Estoques")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidade;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstoque")
    @JsonManagedReference
    private Set<Produto> produtos;

    public Estoque(long id, int quantidade, long idProduto) {
        this.id = id;
        this.quantidade = quantidade;
    }
    
    protected Estoque() {
    }

    public long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }


    @Override
    public String toString() {
        return "Estoque [id=" + id + ", quantidade=" + quantidade + "]";
    }


}
