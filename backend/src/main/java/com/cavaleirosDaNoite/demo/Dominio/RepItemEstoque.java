package com.cavaleirosDaNoite.demo.Dominio;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemEstoque;
import com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces.IRepItemEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepItemEstoque {
    private final IRepItemEstoque itemEstoqueRepository;

    @Autowired
    public RepItemEstoque(IRepItemEstoque itemEstoqueRepository) {
        this.itemEstoqueRepository = itemEstoqueRepository;
    }

    public ItemEstoque save(ItemEstoque itemEstoque) {
        itemEstoqueRepository.save(itemEstoque);
        return itemEstoque;
    }

    public void deleteById(long id) {
        itemEstoqueRepository.deleteById(id);
    }

    public ItemEstoque findById(long id) {
        return itemEstoqueRepository.findById(id).get();
    }

    public Iterable<ItemEstoque> findAll() {
        return itemEstoqueRepository.findAll();
    }
}
