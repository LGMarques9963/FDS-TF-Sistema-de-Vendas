package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;
import com.cavaleirosDaNoite.demo.Dominio.RepPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final RepPedidos repPedidos;

    @Autowired
    public PedidoController(RepPedidos repPedidos) {
        this.repPedidos = repPedidos;
    }

    @GetMapping
    @CrossOrigin("*")
    public List<Pedido> getPedidos() {
        return repPedidos.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Pedido getPedidoById(long id) {
        return repPedidos.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    @GetMapping("/cliente/{idCliente}")
    @CrossOrigin("*")
    public List<Pedido> getPedidoByIdCliente(@PathVariable long idCliente) {
        return repPedidos.findByClienteId(idCliente);
    }

    @PostMapping
    @CrossOrigin("*")
    public Pedido postPedido(@RequestBody Pedido pedido) {
        return repPedidos.save(pedido);
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public Pedido putPedido(@RequestBody Pedido pedido, @PathVariable long id) {
        if (repPedidos.findById(id).isEmpty()) { return null; }
        return repPedidos.save(pedido);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deletePedido(@PathVariable long id) {
        repPedidos.deleteById(id);
    }
}
