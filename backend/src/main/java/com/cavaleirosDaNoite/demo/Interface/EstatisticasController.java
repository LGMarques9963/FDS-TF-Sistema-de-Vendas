package com.cavaleirosDaNoite.demo.Interface;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Produto;
import com.cavaleirosDaNoite.demo.Dominio.ServicoEstatisticas.ClientesInadiplentes;
import com.cavaleirosDaNoite.demo.Dominio.ServicoEstatisticas.MesesMaisVendas;
import com.cavaleirosDaNoite.demo.Dominio.ServicoEstatisticas.ProdutosMaisComprados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estatisticas")
public class EstatisticasController {

    private final ClientesInadiplentes clientesInadiplentes;
    private final MesesMaisVendas mesesMaisVendas;
    private final ProdutosMaisComprados produtosMaisComprados;

    @Autowired
    public EstatisticasController(ClientesInadiplentes clientesInadiplentes, MesesMaisVendas mesesMaisVendas,
            ProdutosMaisComprados produtosMaisComprados) {
        this.clientesInadiplentes = clientesInadiplentes;
        this.mesesMaisVendas = mesesMaisVendas;
        this.produtosMaisComprados = produtosMaisComprados;
    }

    @GetMapping("/clientesInadiplentes")
    @CrossOrigin("*")
    public Map<Cliente, Long> clientesInadiplentes() {
        return clientesInadiplentes.clientesInadiplentes();
    }

    @GetMapping("/mesesMaisVendas")
    @CrossOrigin("*")
    public Map<Month, Long> mesesMaisVendas() {
        return mesesMaisVendas.mesesQuantidadeVendas();
    }

    @GetMapping("/produtosMaisComprados")
    @CrossOrigin("*")
    public List<Produto> produtosMaisComprados() {
        return produtosMaisComprados.produtosMaisComprados();
    }

}
