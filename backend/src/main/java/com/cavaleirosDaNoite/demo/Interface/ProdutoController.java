package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;
import com.cavaleirosDaNoite.demo.Dominio.RepProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final RepProdutos repProdutos;

    @Autowired
    public ProdutoController(RepProdutos repProdutos) {
        this.repProdutos = repProdutos;
    }

    @GetMapping
    @CrossOrigin("*")
    public List<Produto> getProdutos() {
        return repProdutos.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Produto getProdutoById(long id) {
        return repProdutos.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @PostMapping
    @CrossOrigin("*")
    public Produto postProduto(@RequestBody Produto produto) {
        return repProdutos.save(produto);
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public Produto putProduto(@RequestBody Produto produto, @PathVariable long id) {
        if (repProdutos.findById(id).isEmpty()) { return null; }
        return repProdutos.save(produto);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public void deleteProduto(@PathVariable long id) {
        repProdutos.deleteById(id);
    }

}
