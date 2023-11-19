package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Aplicacao.ClienteRequest;
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
    public ResponseEntity<?> postCliente(@RequestBody ClienteRequest clienteRequest) {
        try {
            Cliente clienteSalvo = servicoCliente.cadastrarCliente(clienteRequest);
            return ResponseEntity.ok(clienteSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<?> putCliente(@RequestBody ClienteRequest clienteRequest, @PathVariable long id) {
        try{
            Cliente clienteAtualizado = servicoCliente.atualizarCliente(clienteRequest, id);
            if (clienteAtualizado != null) {
                return ResponseEntity.ok(clienteAtualizado);
            } else {
                return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Cliente não encontrado!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deleteCliente(@PathVariable long id) {
        servicoCliente.removerCliente(id);
    }
}
