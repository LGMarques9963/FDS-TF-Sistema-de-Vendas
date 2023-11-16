package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;
import com.cavaleirosDaNoite.demo.Dominio.RepProdutos;
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
    public List<Produto> getProdutos() {
        return servicoProduto.listarProdutos();
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Produto getProdutoById(long id) {
        return servicoProduto.buscarProduto(id);
    }

    @PostMapping
    @CrossOrigin("*")
    public ResponseEntity<String> postProduto(@RequestBody Produto produto) {
        servicoProduto.cadastrarProduto(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<String> putProduto(@RequestBody Produto produto, @PathVariable long id) {
        if (servicoProduto.buscarProduto(id)==null) { return null; }
            servicoProduto.cadastrarProduto(produto);
            return ResponseEntity.ok("Produto atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deleteProduto(@PathVariable long id) {
        servicoProduto.removerProduto(servicoProduto.buscarProduto(id));
    }

}
