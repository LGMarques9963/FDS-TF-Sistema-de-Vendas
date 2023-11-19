package com.cavaleirosDaNoite.demo.Aplicacao;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemEstoque;

import java.util.List;

public class ProdutoRequest {

        private String nome;
        private String descricao;
        private double valor;
        private List<ItemEstoqueRequest> itemEstoque;

        public ProdutoRequest(String nome, String descricao, double valor, List<ItemEstoqueRequest> itemEstoque) {
            this.nome = nome;
            this.descricao = descricao;
            this.valor = valor;
            this.itemEstoque = itemEstoque;
        }

        public ProdutoRequest() {
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public double getValor() {
            return valor;
        }

        public List<ItemEstoqueRequest> getItemEstoque() {
            return itemEstoque;
        }
}
