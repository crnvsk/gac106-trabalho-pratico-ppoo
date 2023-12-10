package br.ufla.gac106.s2023_1.AdventureWorld.relatorios;

public class DadosIngressoVisita implements ContabilizadorIngressos {
    private String nomeAtividade;
    private int quantidadeIngressos;
    private double valorTotal;

    public DadosIngressoVisita(String nomeAtividade, int quantidadeIngressos, double valorTotal) {
        this.nomeAtividade = nomeAtividade;
        this.quantidadeIngressos = quantidadeIngressos;
        this.valorTotal = valorTotal;
    }

    @Override
    public String identificador() {
        return nomeAtividade;
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
