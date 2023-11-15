package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private ServicoCliente servicoCliente;

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
    public ResponseEntity<String> postClientes(@RequestBody Cliente cliente){
        servicoCliente.createCliente(cliente);
        return ResponseEntity.ok("Cliente cadastrado com sucesso!");
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
