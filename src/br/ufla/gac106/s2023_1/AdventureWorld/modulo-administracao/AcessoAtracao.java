package br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao;

public class AcessoAtracao extends Visita {
    
    public AcessoAtracao(String umNome, Parque umParque, Cidade umaCidade, String data, String horario) {
        super(umNome, umParque, umaCidade, data, horario); // Chama o construtor da classe pai (Visita) passando os parâmetros correspondentes
        setValorIngresso(50.0); // Define o valor do ingresso como R$ 50.0
        setTipoIngresso("Ingresso Basico"); // Define o tipo do ingresso como "Ingresso Básico"
        setQtdIngressos(1000);
    }
}
