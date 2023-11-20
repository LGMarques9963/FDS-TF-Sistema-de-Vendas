package com.cavaleirosDaNoite.demo.Dominio.ServicoEstatisticas;

import com.cavaleirosDaNoite.demo.Dominio.Repositorios.RepOrcamentos;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MesesMaisVendas {

    RepOrcamentos repOrcamentos;

    // Metodo que vasculha por todos os orcamentos efetivados e retorna uma lista
    // ordenada pela quantidade de compras realizas naquele mes

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

        Map<Month, Long> mesesComVendas = new LinkedHashMap<>();
        vendasPorMes.entrySet().stream()
                .sorted(Map.Entry.<Month, Long>comparingByValue().reversed())
                .forEachOrdered(entry -> mesesComVendas.put(entry.getKey(), entry.getValue()));

        return mesesComVendas;
    }
}
