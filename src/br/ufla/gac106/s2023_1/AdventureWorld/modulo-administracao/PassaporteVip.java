package br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao;

public class PassaporteVip extends Visita {
    
    public PassaporteVip(String umNome, Parque umParque, Cidade umaCidade, String data, String horario) {
        super(umNome, umParque, umaCidade, data, horario); // Chama o construtor da classe pai (Visita) passando os parâmetros correspondentes
        setValorIngresso(100.0); // Define o valor do ingresso para R$ 100.0
        setTipoIngresso("Passaporte VIP"); // Define o tipo do ingresso como "Passaporte VIP"
        setQtdIngressos(100);
    }
}
