package com.cavaleirosDaNoite.demo.Dominio;

import java.util.List;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;

public class ServicoCliente {
    RepClientes repClientes;

    public ServicoCliente() {}


    public void cadastrarCliente(Cliente cliente) {
        repClientes.save(cliente);
    }

    public void removerCliente(long id) {
        repClientes.deleteById(id);
    }

    public List<Cliente> listarClientes() {
        return repClientes.findAll();
    }
}
