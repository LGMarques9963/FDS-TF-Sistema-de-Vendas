package com.cavaleirosDaNoite.demo.Dominio.Servicos;

import com.cavaleirosDaNoite.demo.Aplicacao.ProdutoRequest;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Estoque;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;
import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepEstoque;
import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoProduto {
    @Autowired
    private final RepProdutos repProdutos;

    @Autowired
    private final RepEstoque repEstoque;

    public ServicoProduto(RepProdutos repProdutos, RepEstoque repEstoque){
        this.repProdutos = repProdutos;
        this.repEstoque = repEstoque;
    }

    public Produto cadastrarProduto(ProdutoRequest produtoRequest){
        Estoque estoque = repEstoque.findById(produtoRequest.getIdEstoque()).orElse(null);
        Produto produto = new Produto(produtoRequest.getNome(), produtoRequest.getDescricao(), produtoRequest.getValor());
        produto.setEstoque(estoque);
        repProdutos.save(produto);
        return produto;
    }

    public void removerProduto(Produto produto){
        repProdutos.deleteById(produto.getId());
    }

    public Produto atualizarProduto(ProdutoRequest produtoRequest, long idProduto){
        Estoque estoque = repEstoque.findById(produtoRequest.getIdEstoque()).orElse(null);
        Produto produtoAtualizado = repProdutos.findById(idProduto).orElse(null);

        if (produtoAtualizado == null) { return null; }

        produtoAtualizado.setValor(produtoRequest.getValor());
        produtoAtualizado.setNome(produtoRequest.getNome());
        produtoAtualizado.setDescricao(produtoRequest.getDescricao());
        produtoAtualizado.setEstoque(estoque);
        repProdutos.save(produtoAtualizado);
        return produtoAtualizado;

    }

    public Produto buscarProduto(long id){
        return repProdutos.findById(id).orElse(null);
    }

    public List<Produto> listarProdutos(){
        return repProdutos.findAll();
    }

}
