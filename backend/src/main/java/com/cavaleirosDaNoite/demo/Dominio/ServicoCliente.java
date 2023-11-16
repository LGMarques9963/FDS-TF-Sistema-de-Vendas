package com.cavaleirosDaNoite.demo.Dominio;

import java.util.List;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoCliente {
    RepClientes repClientes;

    @Autowired
    public ServicoCliente(RepClientes repClientes) {
        this.repClientes = repClientes;
    }


    public Cliente cadastrarCliente(Cliente cliente) {
        repClientes.save(cliente);
        return cliente;
    }

    public void removerCliente(long id) {
        repClientes.deleteById(id);
    }

    public List<Cliente> listarClientes() {
        return repClientes.findAll();
    }

    public Cliente buscarCliente(long id) {
        return repClientes.findById(id).orElse(null);
    }

    public void atualizarCliente(Cliente cliente) {
        repClientes.save(cliente);
    }
}
