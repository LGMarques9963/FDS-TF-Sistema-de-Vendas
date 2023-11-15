package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;

public class ServicoProduto {
    
    RepEstoque repEstoque;

    public ServicoProduto(RepEstoque repEstoque){
        this.repEstoque = repEstoque;
    }

    public void cadastrarProduto(Produto produto){
        repEstoque.cadastrarProduto(produto);
    }

    public void removerProduto(Produto produto){
        repEstoque.removerProduto(produto);
    }

    public void atualizarProduto(Produto produto){
        repEstoque.atualizarProduto(produto);
    }

}
