package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;
import com.cavaleirosDaNoite.demo.Dominio.ServicoPedido;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final ServicoPedido servicoPedido;

    @Autowired
    public PedidoController(ServicoPedido servicoPedido) {
        this.servicoPedido = servicoPedido;
    }

    @GetMapping
    @CrossOrigin("*")
    public List<Pedido> getPedidos() {
        return servicoPedido.listarPedidos();
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Pedido getPedidoById(long id) {
        return servicoPedido.buscarPedido(id);
    }

    @GetMapping("/cliente/{idCliente}")
    @CrossOrigin("*")
    public List<Pedido> getPedidoByIdCliente(@PathVariable long idCliente) {
        return servicoPedido.buscarPedidoCliente(idCliente);
    }

    @PostMapping
    @CrossOrigin("*")
    public ResponseEntity<String> postPedido(@RequestBody Pedido pedido) {

        servicoPedido.cadastrarPedido(pedido);
        return ResponseEntity.ok("Pedido cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<String> putPedido(@RequestBody Pedido pedido, @PathVariable long id) {
        if (servicoPedido.buscarPedidoCliente(id).isEmpty()) { return null; }
            servicoPedido.cadastrarPedido(pedido);
            return ResponseEntity.ok("Pedido atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deletePedido(@PathVariable long id) {
        servicoPedido.removerPedido(id);
    }
}
