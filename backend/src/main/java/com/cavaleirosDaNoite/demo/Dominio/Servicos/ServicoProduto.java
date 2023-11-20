package com.cavaleirosDaNoite.demo.Dominio.Servicos;

import com.cavaleirosDaNoite.demo.Aplicacao.ProdutoRequest;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Estoque;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemEstoque;
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
        Produto produto = new Produto(produtoRequest.getNome(), produtoRequest.getDescricao(), produtoRequest.getValor());
        List<ItemEstoque> itensEstoque = produtoRequest.getItemEstoque().stream()
                .map(itemEstoqueRequest -> {
                    Estoque estoque = repEstoque.findById(itemEstoqueRequest.getIdEstoque()).orElse(null);
                    return new ItemEstoque(estoque, produto, itemEstoqueRequest.getQuantidadeAtual(), itemEstoqueRequest.getQuantidadeMax());
                }).toList();
        produto.setItemEstoque(itensEstoque);
        System.out.println("Produto criado: " + produto.toString());
        repProdutos.save(produto);
        return produto;
    }

    public void removerProduto(Produto produto){
        repProdutos.deleteById(produto.getId());
    }

    public Produto atualizarProduto(ProdutoRequest produtoRequest, long idProduto){
        Produto produtoAtualizado = repProdutos.findById(idProduto).orElse(null);
        if (produtoAtualizado == null) { return null; }
        System.out.println("Produto recebido: " + produtoRequest.toString() + " id: " + idProduto);
        System.out.println("Produto existente: " + produtoAtualizado.toString() + " id: " + produtoAtualizado.getId());
        List<ItemEstoque> itensEstoque = produtoRequest.getItemEstoque().stream()
                .map(itemEstoqueRequest -> {
                    Estoque estoqueAtualizado = repEstoque.findById(itemEstoqueRequest.getIdEstoque()).orElse(null);
                    return new ItemEstoque(estoqueAtualizado, produtoAtualizado, itemEstoqueRequest.getQuantidadeAtual(), itemEstoqueRequest.getQuantidadeMax());
                }).toList();
        produtoAtualizado.setValor(produtoRequest.getValor());
        produtoAtualizado.setNome(produtoRequest.getNome());
        produtoAtualizado.setDescricao(produtoRequest.getDescricao());
        produtoAtualizado.updateItemEstoque(itensEstoque);
        System.out.println("Produto atualizado: " + produtoAtualizado.toString());
        return repProdutos.save(produtoAtualizado);

    }

    public Produto buscarProduto(long id){
        return repProdutos.findById(id).orElse(null);
    }

    public List<Produto> listarProdutos(){
        return repProdutos.findAll();
    }

}
