package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemPedido;
import com.cavaleirosDaNoite.demo.Dominio.Servicos.ServicoItemPedido;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
public class MainController {

    private final ServicoItemPedido servicoItemPedido;

    @Autowired
    public MainController(ServicoItemPedido servicoItemPedido){
        this.servicoItemPedido = servicoItemPedido;


    }

    @GetMapping("/itempedido")
    @CrossOrigin("*")
    public List<ItemPedido> getClientes() {
        return servicoItemPedido.listarItemPedido();
    }
}
