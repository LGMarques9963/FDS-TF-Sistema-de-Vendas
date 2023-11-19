package com.cavaleirosDaNoite.demo.Aplicacao;

public class ProdutoRequest {

        private String nome;
        private String descricao;
        private double valor;
        private long idEstoque;

        public ProdutoRequest(String nome, String descricao, double valor, long idEstoque) {
            this.nome = nome;
            this.descricao = descricao;
            this.valor = valor;
            this.idEstoque = idEstoque;
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

        public long getIdEstoque() {
            return idEstoque;
        }
}
