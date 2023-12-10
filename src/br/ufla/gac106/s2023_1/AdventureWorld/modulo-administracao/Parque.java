package br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao;

import java.util.ArrayList;
import java.io.Serializable;

public class Parque implements Serializable{
    private String nomeParque; // Variável para armazenar o nome do parque
    private ArrayList<String> atracoesDisponiveis; // Lista de atrações disponíveis no parque
    private int qtdIngressosVendidos;

    

    public Parque(String umNome, ArrayList<String> atracoes) {
        this.nomeParque = umNome; // Atribui o nome do parque ao atributo nomeParque
        this.atracoesDisponiveis = atracoes; // Atribui a lista de atrações ao atributo atracoesDisponiveis
        this.qtdIngressosVendidos = 0;
    }

    public String getNomeParque() {
        return this.nomeParque; // Retorna o nome do parque
    }

    public ArrayList<String> getAtracoesDisponiveis() {
        return this.atracoesDisponiveis; // Retorna a lista de atrações disponíveis
    }

    public String getDescricao() {
        String saida = "";
        saida += "Nome do parque: " + nomeParque + "\n";
        saida += "Atrações disponíveis: ";
        ArrayList<String> atracoes = atracoesDisponiveis;
        for (String atracao : atracoes) {
            saida += "> " + atracao + "\n";
        }
        saida += "------\n";
        return saida;
    }

    public String exibirAtracoes(){
        String saida = "";
        ArrayList<String> atracoes = atracoesDisponiveis;
        for (String atracao : atracoes) {
            saida += "\n    > " + atracao;
        }
        //saida += "\n";
        return saida;
    }

    public void setNomeParque(String nomeParque) {
        this.nomeParque = nomeParque;
    }
    public void setAtracoesDisponiveis(ArrayList<String> atracoesDisponiveis) {
        this.atracoesDisponiveis = atracoesDisponiveis;
    }

    public int getQtdIngressosVendidos() {
        return this.qtdIngressosVendidos;
    }

    public void setQtdIngressosVendidos(int qtdIngressosVendidos) {
        this.qtdIngressosVendidos = qtdIngressosVendidos;
    }
}
