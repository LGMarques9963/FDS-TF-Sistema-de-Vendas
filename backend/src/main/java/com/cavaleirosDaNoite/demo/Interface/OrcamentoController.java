package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.RepOrcamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orcamento")
public class OrcamentoController {

    private final RepOrcamentos orcamentoRepository;

    @Autowired
    public OrcamentoController(RepOrcamentos orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    @GetMapping
    @CrossOrigin("*")
    public List<Orcamento> getOrcamentos() {
        return orcamentoRepository.findAll();
    }

    @GetMapping("/vencidos")
    @CrossOrigin("*")
    public List<Orcamento> getOrcamentosVencidos() {
        return orcamentoRepository.findByVencidoTrue();
    }

    @GetMapping("/validos")
    @CrossOrigin("*")
    public List<Orcamento> getOrcamentosValidos() {
        return orcamentoRepository.findByVencidoFalse();
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Orcamento getOrcamento(long id) {
        return orcamentoRepository.findById(id).orElse(null);
    }

    @GetMapping("/cliente/{id}")
    @CrossOrigin("*")
    public List<Orcamento> getOrcamentoCliente(long id) {
        return orcamentoRepository.findByClienteId(id);
    }

    @PostMapping
    @CrossOrigin("*")
    public Orcamento saveOrcamento(@RequestBody Orcamento orcamento) {
        return orcamentoRepository.save(orcamento);
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public Orcamento efetivarOrcamento(@PathVariable long id) {
        Orcamento orcamento = orcamentoRepository.findById(id).orElse(null);
        if (orcamento != null) {
            return orcamentoRepository.save(orcamento);
        }
        return null;
    }



}
