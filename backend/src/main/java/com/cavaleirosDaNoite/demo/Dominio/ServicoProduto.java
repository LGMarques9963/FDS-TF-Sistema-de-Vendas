package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoProduto {
    
    private final RepProdutos repProdutos;

    public ServicoProduto(RepProdutos repProdutos){
        this.repProdutos = repProdutos;
    }

    public void cadastrarProduto(Produto produto){
        repProdutos.save(produto);
    }

    public void removerProduto(Produto produto){
        repProdutos.deleteById(produto.getId());
    }

    public void atualizarProduto(Produto produto){
        repProdutos.save(produto);
    }

    public Produto buscarProduto(long id){
        return repProdutos.findById(id).orElse(null);
    }

    public List<Produto> listarProdutos(){
        return repProdutos.findAll();
    }

}
