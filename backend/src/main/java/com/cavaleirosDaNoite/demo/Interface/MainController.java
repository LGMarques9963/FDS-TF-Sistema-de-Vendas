package com.cavaleirosDaNoite.demo.Interface;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api")
public class MainController {
    
    @Autowired
    public MainController(){

    }


    // lISTAR PRODUTOS
    @GetMapping("/produtos")
    @CrossOrigin("*")
    public String getProdutos(){
        return "Lista de produtos - Verbo GET";
    }

    // ADICIONAR PRODUTOS
    @PostMapping("/produtos")
    @CrossOrigin("*")
    public String postProdutos(){
        return "Adicionando produtos - Verbo POST";
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

    // CADASTRAR CLIENTE
    @PostMapping("/clientes")
    @CrossOrigin("*")
    public String postClientes(){
        return "Cadastrando cliente - Verbo POST";
    }

    // LISTAR CLIENTES
    @GetMapping("/clientes")
    @CrossOrigin("*")
    public String getClientes(){
        return "Listando clientes - Verbo GET";
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
