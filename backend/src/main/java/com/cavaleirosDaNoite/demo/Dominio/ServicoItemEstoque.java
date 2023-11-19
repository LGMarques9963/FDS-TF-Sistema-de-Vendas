package com.cavaleirosDaNoite.demo.Dominio;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Estoque;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemEstoque;


@Service
public class ServicoItemEstoque {
    
    RepItemEstoque repItemEstoque;

    @Autowired
    public ServicoItemEstoque(RepItemEstoque repItemEstoque) {
        this.repItemEstoque = repItemEstoque;
    }

    public void cadastrarItemEstoque(ItemEstoque itemEstoque) {
        repItemEstoque.save(itemEstoque);
    }

    public void removerItemEstoque(long id) {
        repItemEstoque.deleteById(id);
    }

    public ItemEstoque buscarItemEstoque(long id) {
        return repItemEstoque.findById(id);
    }

    public ItemEstoque atualizarItemEstoque(ItemEstoque itemEstoque) {
        System.out.println("ItemEstoque recebido: " + itemEstoque.toString()  + " id: " + itemEstoque.getId());
        return repItemEstoque.save(itemEstoque);
    }

    public Iterable<ItemEstoque> listarItemEstoque() {
        return repItemEstoque.findAll();
    }

    
}
