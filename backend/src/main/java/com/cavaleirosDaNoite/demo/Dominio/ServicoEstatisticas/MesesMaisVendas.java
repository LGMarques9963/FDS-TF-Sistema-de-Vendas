package com.cavaleirosDaNoite.demo.Dominio.ServicoEstatisticas;

import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepOrcamentos;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MesesMaisVendas {

    RepOrcamentos repOrcamentos;

    @Autowired
    public MesesMaisVendas(RepOrcamentos repOrcamentos) {
        this.repOrcamentos = repOrcamentos;
    }

    public Map<Month, Long> mesesQuantidadeVendas() {
        Map<Month, Long> vendasPorMes = repOrcamentos.findAll().stream()
                .filter(Orcamento::isEfetivado)
                .collect(Collectors.groupingBy(
                        orcamento -> orcamento.getData().getMonth(),
                        Collectors.counting()));

        Map<Month, Long> mesesComVendas = new EnumMap<>(Month.class);
        for (Month mes : Month.values()) {
            Long quantidade = vendasPorMes.getOrDefault(mes, 0L);
            mesesComVendas.put(mes, quantidade);
        }

        return mesesComVendas;
    }
}
