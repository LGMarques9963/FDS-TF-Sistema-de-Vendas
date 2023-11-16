package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.RepOrcamentos;
import com.cavaleirosDaNoite.demo.Dominio.ServicoOrcamento;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Orcamento getOrcamento(long id) {
        return servicoOrcamento.buscarOrcamento(id);
    }

    @GetMapping("/cliente/{id}")
    @CrossOrigin("*")
    public List<Orcamento> getOrcamentoCliente(long id) {
        return servicoOrcamento.orcamentosCliente(id);
    }

    @PostMapping
    @CrossOrigin("*")
    public Orcamento saveOrcamento(@RequestBody Orcamento orcamento) {
        return servicoOrcamento.solicitarOrcamento(orcamento.getPedido(), orcamento.getCliente());
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public Orcamento efetivarOrcamento(@PathVariable long id) {
        Orcamento orcamento = servicoOrcamento.buscarOrcamento(id);
        if (orcamento != null) {
            return servicoOrcamento.solicitarOrcamento(orcamento.getPedido(), orcamento.getCliente());
        }
        return null;
    }



}
