package com.cavaleirosDaNoite.demo.Aplicacao;

public class ItemEstoqueRequest {

    private long idEstoque;
    private int quantidadeAtual;

    private int quantidadeMax;

    public ItemEstoqueRequest(long idEstoque, int quantidadeAtual, int quantidaMax) {
        this.idEstoque = idEstoque;
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMax = quantidaMax;
    }

    public ItemEstoqueRequest() {
    }

    public long getIdEstoque() {
        return idEstoque;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public int getQuantidadeMax() {
        return quantidadeMax;
    }

    public void setIdEstoque(long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public void setQuantidadeMax(int quantidadeMax) {
        this.quantidadeMax = quantidadeMax;
    }

}
