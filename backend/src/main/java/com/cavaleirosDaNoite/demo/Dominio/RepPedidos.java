package com.cavaleirosDaNoite.demo.Dominio;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;
import com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces.IRepPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepPedidos {
    private final IRepPedido pedidoRepository;

    // Injeção de dependência do IRepPedidos

    @Autowired
    public RepPedidos(IRepPedido pedidoRepository) {

        this.pedidoRepository = pedidoRepository;
    }


    public Optional<Pedido> findById(long id) { // Procurar pela Id
        return pedidoRepository.findById(id);
    }

    
    public List<Pedido> findByClienteId(long idCliente) { // Procurar pela Id do cliente
        return pedidoRepository.findByClienteId(idCliente);
    }

    public List<Pedido> findAll() { // Listar todos
        return (List<Pedido>) pedidoRepository.findAll();
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deleteById(long id) {
        pedidoRepository.deleteById(id);
    }
}
