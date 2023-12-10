package br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao;

import br.ufla.gac106.s2023_1.AdventureWorld.compraIngressos.Menu;

public class App {
    public static void main(String[] args) {
        /*
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(); // Cria uma instância da classe InterfaceUsuario
        interfaceUsuario.executar(); // Chama o método executar() da instância da InterfaceUsuario
         */
        Central central = new Central();
        central.carregarDados("dados.bin");
        Menu menu = new Menu(null, true, false, false, central);
        menu.setVisible(true);
    }
}
