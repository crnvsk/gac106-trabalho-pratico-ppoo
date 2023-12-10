package br.ufla.gac106.s2023_1.AdventureWorld.relatorios;

public class DadosIngressoParque implements ContabilizadorIngressos {
    private String nomeParque;
    private int quantidadeIngressos;
    private double valorTotal;

    public DadosIngressoParque(String nomeParque, int quantidadeIngressos, double valorTotal) {
        this.nomeParque = nomeParque;
        this.quantidadeIngressos = quantidadeIngressos;
        this.valorTotal = valorTotal;
    }

    @Override
    public String identificador() {
        return nomeParque;
    }

    @Override
    public int quantidadeIngressos() {
        return quantidadeIngressos;
    }

    @Override
    public double valorTotal() {
        return valorTotal;
    }
}
