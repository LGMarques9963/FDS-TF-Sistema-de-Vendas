package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.ServicoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ServicoCliente servicoCliente;

    @Autowired
    public ClienteController(ServicoCliente servicoCliente) {
        this.servicoCliente = servicoCliente;
    }

    @GetMapping
    @CrossOrigin("*")
    public List<Cliente> getClientes() {
        return servicoCliente.listarClientes();
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Cliente getClienteById(long id) {
        return servicoCliente.buscarCliente(id);
    }

    @PostMapping
    @CrossOrigin("*")
    public ResponseEntity<String> postCliente(@RequestBody Cliente cliente) {
        servicoCliente.cadastrarCliente(cliente);
        return ResponseEntity.ok("Cliente Cadastrado!");
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<String> putCliente(@RequestBody Cliente cliente, @PathVariable long id) {
        if (servicoCliente.buscarCliente(id) == null) { return null; }
        servicoCliente.atualizarCliente(cliente);
        return ResponseEntity.ok("Cliente Atualizado com Sucesso!");
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deleteCliente(@PathVariable long id) {
        servicoCliente.removerCliente(id);
    }
}
