package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Aplicacao.PedidoRequest;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;
import com.cavaleirosDaNoite.demo.Dominio.ServicoPedido;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

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
    public Pedido getPedidoById(@PathVariable long id) {
        return servicoPedido.buscarPedido(id);
    }

    @GetMapping("/cliente/{idCliente}")
    @CrossOrigin("*")
    public List<Pedido> getPedidoByIdCliente(@PathVariable long idCliente) {
        return servicoPedido.buscarPedidoCliente(idCliente);
    }

    @PostMapping
    @CrossOrigin("*")
    public ResponseEntity<Pedido> postPedido(@RequestBody PedidoRequest pedidoRequest) {
        System.out.println(pedidoRequest);
        try{
            Pedido pedido = servicoPedido.cadastrarPedido(pedidoRequest);
            return ResponseEntity.ok(pedido);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<String> putPedido(@RequestBody Pedido pedido, @PathVariable long id) {
        if (servicoPedido.buscarPedidoCliente(id).isEmpty()) { return null; }
//            servicoPedido.cadastrarPedido(pedido);
            return ResponseEntity.ok("Pedido atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deletePedido(@PathVariable long id) {
        servicoPedido.removerPedido(id);
    }
}
