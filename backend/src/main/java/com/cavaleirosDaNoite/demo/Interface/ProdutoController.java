package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;
import com.cavaleirosDaNoite.demo.Dominio.ServicoProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ServicoProduto servicoProduto;

    @Autowired
    public ProdutoController(ServicoProduto servicoProduto) {
        this.servicoProduto = servicoProduto;
    }

    @GetMapping
    @CrossOrigin("*")
    public ResponseEntity<List<Produto>> getProdutos() {
        try {
            return ResponseEntity.ok(servicoProduto.listarProdutos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Produto getProdutoById(@PathVariable long id) {
        return servicoProduto.buscarProduto(id);
    }

    @PostMapping
    @CrossOrigin("*")
    public ResponseEntity<String> postProduto(@RequestBody Produto produto, @RequestParam long idEstoque) {
        try {
            Produto produtoAtualizado = servicoProduto.cadastrarProduto(produto, idEstoque);
            return ResponseEntity.ok(produtoAtualizado.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<String> putProduto(@RequestBody Produto produto, @PathVariable long id, @RequestParam long idEstoque) {
        try {
            Produto produtoAtualizado = servicoProduto.atualizarProduto(produto, idEstoque, id);
            return ResponseEntity.ok(produtoAtualizado.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deleteProduto(@PathVariable long id) {
        servicoProduto.removerProduto(servicoProduto.buscarProduto(id));
    }

}
