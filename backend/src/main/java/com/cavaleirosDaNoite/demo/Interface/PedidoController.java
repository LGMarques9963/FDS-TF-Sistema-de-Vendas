package com.cavaleirosDaNoite.demo.Interface;

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
    public ResponseEntity<String> postPedido(@RequestBody List<String> itemPedido) {
        List<ItemPedido> itemPedido2 = new ArrayList<>();
        for (String item : itemPedido) {
            itemPedido2.add(new ItemPedido(item));
        }
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
