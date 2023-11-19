package com.cavaleirosDaNoite.demo.Dominio.Servicos;

import java.util.List;

import com.cavaleirosDaNoite.demo.Aplicacao.ClienteRequest;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoCliente {
    RepClientes repClientes;

    @Autowired
    public ServicoCliente(RepClientes repClientes) {
        this.repClientes = repClientes;
    }


    public Cliente cadastrarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente(clienteRequest.getNome(), clienteRequest.getCpf(), clienteRequest.getEmail(), clienteRequest.getSenha());
        return repClientes.save(cliente);
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

    public Cliente atualizarCliente(ClienteRequest clienteRequest, long id) {
        Cliente clienteExistente = repClientes.findById(id).orElse(null);
        if (clienteExistente != null) {
            // Copiar os dados atualizados para o cliente existente
            clienteExistente.setNome(clienteRequest.getNome());
            clienteExistente.setCpf(clienteRequest.getCpf());
            clienteExistente.setEmail(clienteRequest.getEmail());
            clienteExistente.setSenha(clienteRequest.getSenha());
            return repClientes.save(clienteExistente);
        } else {
            return null;
        }
    }
}
