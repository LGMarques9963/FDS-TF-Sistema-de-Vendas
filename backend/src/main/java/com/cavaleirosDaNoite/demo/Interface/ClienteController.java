package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.RepClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final RepClientes repClientes;

    @Autowired
    public ClienteController(RepClientes repClientes) {
        this.repClientes = repClientes;
    }

    @GetMapping
    @CrossOrigin("*")
    public List<Cliente> getClientes() {
        return repClientes.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Cliente getClienteById(long id) {
        return repClientes.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @PostMapping
    @CrossOrigin("*")
    public Cliente postCliente(@RequestBody Cliente cliente) {
        return repClientes.save(cliente);
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public Cliente putCliente(@RequestBody Cliente cliente, @PathVariable long id) {
        if (repClientes.findById(id).isEmpty()) { return null; }
        return repClientes.save(cliente);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deleteCliente(@PathVariable long id) {
        repClientes.deleteById(id);
    }
}
