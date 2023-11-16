package com.cavaleirosDaNoite.demo.Dominio;
import com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces.IRepEstoque;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Estoque;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepEstoque {
    private final IRepEstoque estoqueRepository;

    // Injeção de dependência do IRepEstoque

    @Autowired
    public RepEstoque(IRepEstoque estoqueRepository) {

        this.estoqueRepository = estoqueRepository;
    }


    public Optional<Estoque> findById(long id) { // Procurar pela Id

        return estoqueRepository.findById(id);
    }

    public List<Estoque> findAll() { //  Listar todos

        return (List<Estoque>) estoqueRepository.findAll();
    }

    public List<Estoque> findMinimumByQuantidadeAtualLessThan(int minQuant) { // Procurar quais estão abaixo da quantidade minima

        return estoqueRepository.findByQuantidadeLessThan(minQuant);
    }


    public void cadastrarProduto(Produto produto) {
    }


    public void removerProduto(Produto produto) {
    }


    public void atualizarProduto(Produto produto) {
    }

    // Adicione outras consultas conforme necessário
}
