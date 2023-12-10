package br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao;

import java.io.Serializable;
import java.util.ArrayList;

public class Visita implements Serializable {
    private String nomeVisita; // Variável para armazenar o nome da visita
    private Parque parque; // Objeto do tipo Parque para representar o parque visitado
    private Cidade cidade; // Objeto do tipo Cidade para representar a cidade da visita
    private String data; // Variável para armazenar a data da visita
    private String horario; // Variável para armazenar o horário da visita
    private String tipoIngresso; // Variável para armazenar o tipo de ingresso da visita
    private ArrayList<String> nomeComprador = new ArrayList<>();
    private double precoIngresso; // Variável para armazenar o preço do ingresso da visita
    private int qtdIngressos;
    private int qtdIngressosVendidos;

    public Visita(String umNome, Parque umParque, Cidade umaCidade, String data, String horario) {
        this.nomeVisita = umNome; // Atribui o nome da visita ao atributo nomeVisita
        this.parque = umParque; // Atribui o objeto Parque recebido como parâmetro ao atributo parque
        this.cidade = umaCidade; // Atribui o objeto Cidade recebido como parâmetro ao atributo cidade
        this.data = data; // Atribui a data recebida como parâmetro ao atributo data
        this.horario = horario; // Atribui o horário recebido como parâmetro ao atributo horario
        this.qtdIngressosVendidos = 0;
    }

    public Visita(){
        nomeComprador = new ArrayList<>();
    }

    public String getNomeVisita() {
        return this.nomeVisita; // Retorna o nome da visita
    }

    public Parque getParque() {
        return this.parque; // Retorna o objeto Parque representando o parque visitado
    }

    public Cidade getCidade() {
        return this.cidade; // Retorna o objeto Cidade representando a cidade da visita
    }

    public String getData() {
        return this.data; // Retorna a data da visita
    }

    public String getHorario() {
        return this.horario; // Retorna o horário da visita
    }

    public void setTipoIngresso(String tipoIngresso) {
        this.tipoIngresso = tipoIngresso; // Define o tipo de ingresso da visita
    }

    public void setValorIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso; // Define o preço do ingresso da visita
    }

    public String getIngresso() {
        return this.tipoIngresso; // Retorna o tipo de ingresso da visita
    }

    public double getPrecoIngresso() {
        return this.precoIngresso; // Retorna o preço do ingresso da visita
    }

    public int getQtdIngresso(){
        return this.qtdIngressos;
    }

    public void setQtdIngressos(int qtdIngressos){
        this.qtdIngressos = qtdIngressos;
    }

    public void vendaIngresso(int qtdIngressos){
        if(qtdIngressos < this.qtdIngressos){
            int resultado = this.qtdIngressos -= qtdIngressos;
            int result = this.qtdIngressosVendidos + qtdIngressos;
            setQtdIngressosVendidos(result);
            setQtdIngressos(resultado);
        }
    }

    public void setQtdIngressosVendidosParque(int qtdIngressos){
        int dado = parque.getQtdIngressosVendidos();
        int result = dado + qtdIngressos;
        parque.setQtdIngressosVendidos(result);
    }

    public String getNomeComprador(int posicao){
        return this.nomeComprador.get(posicao);
    }

    public void setNomeComprador(String nome){
        nomeComprador.add(nome);
    }

    public String getNomeParque(){
       String result = parque.getNomeParque();
       return result;
    }

    public String getNomeCidade(){
       String result = cidade.getNomeCidade();
       return result;
    }

    public String exibirAtracoesParque(){
        String saida = "";
        ArrayList<String> atracoes = parque.getAtracoesDisponiveis();
        for (String atracao : atracoes) {
            saida += "\n    > " + atracao;
        }
        //saida += "\n";
        return saida;
    }

    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
    }

    public void setParque(Parque parque) {
        this.parque = parque;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTipoIngresso() {
        return this.tipoIngresso;
    }

    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public int getQtdIngressos() {
        return this.qtdIngressos;
    }

    public int getQtdIngressosVendidos() {
        return this.qtdIngressosVendidos;
    }

    public void setQtdIngressosVendidos(int qtdIngressosVendidos) {
        this.qtdIngressosVendidos = qtdIngressosVendidos;
    }

    public String getDescricao() {
        String saida = "";
        saida += "Visita: " + nomeVisita + "\n";
        saida += "Parque: " + parque.getNomeParque() + "\n";
        saida += "Cidade: " + cidade.getNomeCidade() + "\n";
        saida += "Tipo de Ingresso: " + tipoIngresso + "\n";
        saida += "Preço do Ingresso: " + precoIngresso + "\n";
        saida += "Data: " + data + "\n";
        saida += "Horário: " + horario + "\n";
        saida += "---------------\n";
        return saida;
    }

    public String getDescricaoCompleta() {
        String saida = "";
        saida += "Visita: " + nomeVisita + "\n";
        saida += "Parque: " + parque.getNomeParque() + "\n";
        saida += "Atrações: " + parque.exibirAtracoes() + "\n";
        saida += "Cidade: " + cidade.getNomeCidade() + "\n";
        saida += "Tipo de Ingresso: " + tipoIngresso + "\n";
        saida += "Preço do Ingresso: " + precoIngresso + "\n";
        saida += "Quantidade de Ingressos disponíveis: " + qtdIngressos + "\n";
        saida += "Data: " + data + "\n";
        saida += "Horário: " + horario + "\n";
        saida += "------------------------------\n";
        return saida;
    }
}
