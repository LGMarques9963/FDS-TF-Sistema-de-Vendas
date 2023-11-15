package com.cavaleirosDaNoite.demo.Dominio;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;
import com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces.IRepProdutos;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepProdutos {
    private final IRepProdutos produtoRepository;

    @Autowired
    public RepProdutos(IRepProdutos produtoRepository) {

        this.produtoRepository = produtoRepository;
    }

    // Restante da sua lógica aqui


    public Optional<Produto> findById(long id) { // Procurar pela Id

        return produtoRepository.findById(id);
    }

    public List<Produto> findAll() {// Listar todos

        return (List<Produto>) produtoRepository.findAll();
    }



    // Adicione outras consultas conforme necessário
}
