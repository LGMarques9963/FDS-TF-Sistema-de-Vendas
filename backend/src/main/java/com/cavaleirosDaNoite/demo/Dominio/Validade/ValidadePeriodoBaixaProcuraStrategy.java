package com.cavaleirosDaNoite.demo.Dominio.Validade;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class ValidadePeriodoBaixaProcuraStrategy implements ValidadeStrategy {
    public LocalDate calcularPrazoValidade(Orcamento orcamento) {
        LocalDate dataOrcamento = orcamento.getData();
        List<String> periodosBaixaProcura = Arrays.asList("07", "12", "01", "02");
        boolean periodoBaixaProcura = periodosBaixaProcura.contains(dataOrcamento.getMonthValue());
        if (periodoBaixaProcura){
            return orcamento.getData().plusDays(35);
        }else{
            return orcamento.getData().plusDays(21);
        }
    }
}
