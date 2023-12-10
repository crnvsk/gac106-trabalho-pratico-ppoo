package br.ufla.gac106.s2023_1.AdventureWorld.relatorios;

public class DadosIngressoComprador implements ContabilizadorIngressos {
    private String nomeComprador;
    private int quantidadeIngressos;
    private double valorTotal;

    public DadosIngressoComprador(String nomeComprador, int quantidadeIngressos, double valorTotal) {
        this.nomeComprador = nomeComprador;
        this.quantidadeIngressos = quantidadeIngressos;
        this.valorTotal = valorTotal;
    }

    @Override
    public String identificador() {
        return nomeComprador;
    }

    @Override
    public int quantidadeIngressos() {
        return quantidadeIngressos;
    }

    @Override
    public double valorTotal() {
        return valorTotal;
    }

    // Método para atualizar a quantidade de ingressos
    public void setQuantidadeIngressos(int quantidadeIngressos) {
        this.quantidadeIngressos = quantidadeIngressos;
    }

    // Método para atualizar o valor total
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
