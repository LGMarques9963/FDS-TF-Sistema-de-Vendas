package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Aplicacao.PedidoRequest;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;
import com.cavaleirosDaNoite.demo.Dominio.Servicos.ServicoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Pedido> getPedidoById(@PathVariable long id) {

        return ResponseEntity.ok(servicoPedido.buscarPedido(id));
    }

    @GetMapping("/cliente/{idCliente}")
    @CrossOrigin("*")
    public List<Pedido> getPedidoByIdCliente(@PathVariable long idCliente) {
        return servicoPedido.buscarPedidoCliente(idCliente);
    }

    @PostMapping
    @CrossOrigin("*")
    public ResponseEntity<Pedido> postPedido(@RequestBody PedidoRequest pedidoRequest) {
        try {
            Pedido pedido = servicoPedido.cadastrarPedido(pedidoRequest);
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            // Log detalhado da exceção para fins de depuração
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<?> putPedido(@RequestBody PedidoRequest pedidoRequest, @PathVariable long id) {
        if (servicoPedido.buscarPedido(id) == null) { return ResponseEntity.badRequest().body("Pedido não encontrado!"); }
        try{
            Pedido pedidoAtualizado = servicoPedido.atualizarPedido(pedidoRequest, id);
            return ResponseEntity.ok(pedidoAtualizado.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao atualizar pedido: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deletePedido(@PathVariable long id) {
        servicoPedido.removerPedido(id);
    }
}
