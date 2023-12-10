package br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao;

import java.io.Serializable;

public class Cidade implements Serializable{
    private String nomeCidade; // Atributo privado para armazenar o nome da cidade
    private String estado; // Atributo privado para armazenar o estado da cidade

    public Cidade(String umNome, String umEstado) {
        this.nomeCidade = umNome; // Inicializa o atributo "nomeCidade" com o valor fornecido
        this.estado = umEstado; // Inicializa o atributo "estado" com o valor fornecido
    }

    public String getNomeCidade() {
        return this.nomeCidade; // Retorna o valor do atributo "nomeCidade"
    }

    public String getEstado() {
        return this.estado; // Retorna o valor do atributo "estado"
    }

    public String getDescricao() {
        String saida = "";
        saida += "Nome da cidade: " + nomeCidade + "\n";
        saida += "Nome do estado: " + estado + "\n";
        saida += "------\n";
        return saida;
    }
}
