package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.Servicos.ServicoOrcamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orcamento")
public class OrcamentoController {

    private final ServicoOrcamento servicoOrcamento;

    @Autowired
    public OrcamentoController(ServicoOrcamento servicoOrcamento) {
        this.servicoOrcamento = servicoOrcamento;
    }

    @GetMapping
    @CrossOrigin("*")
    public List<Orcamento> getOrcamentos() {
        return servicoOrcamento.listarOrcamentos();
    }

    @GetMapping("/vencidos")
    @CrossOrigin("*")
    public List<Orcamento> getOrcamentosVencidos() {
        return servicoOrcamento.orcamentosVencidos();
    }

    @GetMapping("/validos")
    @CrossOrigin("*")
    public List<Orcamento> getOrcamentosValidos() {
        return servicoOrcamento.orcamentosValidos();
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Orcamento getOrcamento(@PathVariable long id) {
        return servicoOrcamento.buscarOrcamento(id);
    }

    @GetMapping("/cliente/{id}")
    @CrossOrigin("*")
    public List<Orcamento> getOrcamentoCliente(@PathVariable long id) {
        return servicoOrcamento.orcamentosCliente(id);
    }

    @PostMapping
    @CrossOrigin("*")
    public Orcamento saveOrcamento(@RequestParam long idPedido) {
        return servicoOrcamento.solicitarOrcamento(idPedido);
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<?> efetivarOrcamento(@PathVariable long id) {
        try{
            return ResponseEntity.ok(servicoOrcamento.efetivarOrcamento(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao efetivar orçamento: Orcamento não encontrado");
        }
    }



}
