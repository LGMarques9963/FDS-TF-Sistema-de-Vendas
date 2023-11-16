package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.ServicoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Cliente getClienteById(@PathVariable long id) {
        return servicoCliente.buscarCliente(id);
    }

    @PostMapping
    @CrossOrigin("*")
    public ResponseEntity<String> postCliente(@RequestBody Cliente cliente) {
        try {
            Cliente clienteSalvo = servicoCliente.cadastrarCliente(cliente);
            return ResponseEntity.ok(clienteSalvo.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<String> putCliente(@RequestBody Cliente cliente, @PathVariable long id) {
        Cliente clienteExistente = servicoCliente.buscarCliente(id);

        if (clienteExistente != null) {
            // Copiar os dados atualizados para o cliente existente
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setCpf(cliente.getCpf());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setSenha(cliente.getSenha());

            // Atualizar o cliente no banco de dados
            servicoCliente.atualizarCliente(clienteExistente);

            return ResponseEntity.ok("Cliente Atualizado com Sucesso!");
        } else {
            // Cliente não encontrado
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deleteCliente(@PathVariable long id) {
        servicoCliente.removerCliente(id);
    }
}
