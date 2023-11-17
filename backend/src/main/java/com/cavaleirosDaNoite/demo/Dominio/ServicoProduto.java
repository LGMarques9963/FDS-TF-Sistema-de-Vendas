package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Estoque;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;
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

    public Produto cadastrarProduto(Produto produto, long idEstoque){
        Estoque estoque = repEstoque.findById(idEstoque).orElse(null);
        produto.setEstoque(estoque);
        repProdutos.save(produto);
        return produto;
    }

    public void removerProduto(Produto produto){
        repProdutos.deleteById(produto.getId());
    }

    public Produto atualizarProduto(Produto produto, long idEstoque, long idProduto){
        Estoque estoque = repEstoque.findById(idEstoque).orElse(null);
        Produto produtoAtualizado = repProdutos.findById(idProduto).orElse(null);

        produtoAtualizado.setValor(produto.getValor());
        produtoAtualizado.setNome(produto.getNome());
        produtoAtualizado.setDescricao(produto.getDescricao());
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
