package com.cavaleirosDaNoite.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cavaleirosDaNoite.demo.Dominio.CalculadoraDescontoValidade;
import com.cavaleirosDaNoite.demo.Dominio.Desconto.DescontoNumeroComprasStrategy;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Orcamento;
import com.cavaleirosDaNoite.demo.Dominio.Entidades.Pedido;
import com.cavaleirosDaNoite.demo.Dominio.Servicos.ServicoCliente;
import com.cavaleirosDaNoite.demo.Dominio.Servicos.ServicoItemPedido;
import com.cavaleirosDaNoite.demo.Dominio.Servicos.ServicoOrcamento;
import com.cavaleirosDaNoite.demo.Dominio.Servicos.ServicoPedido;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DescontoTestes {

    @Autowired
    DescontoNumeroComprasStrategy calculaDesconto;

    @Autowired
    ServicoCliente servicoCliente;

    @BeforeEach
    public void setup() {

    }

    // caso em que o cliente possui 9 orcamentos com um valor de 10.000 para cada,
    // totalizando 90.000
    @DisplayName("Desconto numero compras menor que 10 ")
    @Test
    public void testaDescontoComprasMenor10() {

        Cliente clienteTest = servicoCliente.buscarCliente(2);

        double val = calculaDesconto.calcularDesconto(0, clienteTest);

        double resp = Math.round(val * 1000.0) / 1000.0;

        double obser = 0.045;

        assertEquals(obser, resp);
    }

    // caso em que o cliente possui 11 orcamentos com valor de 10.000 para cada,
    // totalizando 110.000
    @DisplayName("Desconto numero compras maior que 10 ")
    @Test
    public void testaDescontoComprasMaior10() {

        Cliente clienteTest = servicoCliente.buscarCliente(1);

        double val = calculaDesconto.calcularDesconto(0, clienteTest);

        double resp = Math.round(val * 1000.0) / 1000.0;

        double obser = 0.055;

        assertEquals(obser, resp);
    }

    // caso em que o cliente possui 11 orcamentos com valor de 10.000 para cada,
    // totalizando 110.000
    @DisplayName("Desconto numero compras igual a 10 ")
    @Test
    public void testaDescontoComprasIgual10() {

        Cliente clienteTest = servicoCliente.buscarCliente(3);

        double val = calculaDesconto.calcularDesconto(0, clienteTest);

        double resp = Math.round(val * 1000.0) / 1000.0;

        double obser = 0.05;

        assertEquals(obser, resp);
    }
}
