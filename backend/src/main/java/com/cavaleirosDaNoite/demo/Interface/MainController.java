package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    public MainController(){

    }

    // GERAR ORÇAMENTO
    @PostMapping("/orcamentos")
    @CrossOrigin("*")
    public String postOrcamentos(){
        return "Gerando orçamento - Verbo POST";
    }

    // LISTAR ORÇAMENTOS
    @GetMapping("/orcamentos")
    @CrossOrigin("*")
    public String getOrcamentos(){
        return "Lista de orçamentos - Verbo GET";
    }

    // CANCELAR ORÇAMENTO
    @DeleteMapping("/orcamentos")
    @CrossOrigin("*")
    public String deleteOrcamentos(){
        return "Cancelando orçamento - Verbo DELETE";
    }

    // EFETIVAR ORÇAMENTO
    @PutMapping("/orcamentos")
    @CrossOrigin("*")
    public String putOrcamentos(){
        return "Efetivando orçamento - Verbo PUT";
    }

    // GERAR PEDIDO
    @PostMapping("/pedidos")
    @CrossOrigin("*")
    public String postPedidos(){
        return "Gerando pedido - Verbo POST";
    }

    // LISTAR PEDIDOS
    @GetMapping("/pedidos")
    @CrossOrigin("*")
    public String getPedidos(){
        return "Listando pedidos - Verbo GET";
    }



}
