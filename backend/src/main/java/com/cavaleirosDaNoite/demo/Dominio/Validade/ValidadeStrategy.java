package com.cavaleirosDaNoite.demo.Dominio.Validade;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;

import java.time.LocalDate;

public interface ValidadeStrategy {
    LocalDate calcularPrazoValidade(Orcamento orcamento);
}
