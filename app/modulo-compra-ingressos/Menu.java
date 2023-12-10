package br.ufla.gac106.s2023_1.AdventureWorld.compraIngressos;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;

import br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao.Central;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JanelaBase {
    
    protected Central central;
    protected ModuloADM moduloADM;
    protected ModuloCompraIngressos moduloCompraIngressos;
    protected ModuloRelatorio moduloRelatorio;

    public Menu(JanelaBase janelaAnterior, boolean temBotaoFinalizar, boolean temBotaoAvancar, boolean temBotaoVoltar, Central central) {
        super("Escolha do Evento", "Selecione o evento desejado:", 800, 600,
              temBotaoVoltar, janelaAnterior, temBotaoAvancar, temBotaoFinalizar);
        
        this.central = central;
        this.janelaAnterior = janelaAnterior;
        temBotaoFinalizar = true;
        temBotaoAvancar = false;
        temBotaoVoltar = false; 
    }

    @Override
    protected JPanel criarPainelCentral() {
        JPanel painelCentral = new JPanel();
        
        
        JButton botaoEvento1 = new JButton("Módulo Administração");
        botaoEvento1.setPreferredSize(new Dimension(500, 50));
        JButton botaoEvento2 = new JButton("Módulo Compra de Ingressos");
        botaoEvento2.setPreferredSize(new Dimension(500, 50));
        JButton botaoEvento3 = new JButton("Módulo Relatórios");
        botaoEvento3.setPreferredSize(new Dimension(500, 50));
        
        painelCentral.add(botaoEvento1);
        painelCentral.add(botaoEvento2);
        painelCentral.add(botaoEvento3);
   

        botaoEvento1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                registroModuloADM();
            }
        });

        botaoEvento2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                registroModuloIngressos();
            }
        });

        botaoEvento3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                registroModuloRelatorio();
            }
        });
        
        return painelCentral;
    }

    private void registroModuloADM(){
        Menu menu = new Menu(null, true, false, false, central);
        moduloADM = new ModuloADM(menu, true, false, true, central);
        moduloADM.setVisible(true);
        this.dispose();
    }

    private void registroModuloIngressos(){
        Menu menu = new Menu(null, true, false, false, central);
        moduloCompraIngressos = new ModuloCompraIngressos(menu, true, true, true, central);
        moduloCompraIngressos.setVisible(true);
        this.dispose();
    }

    private void registroModuloRelatorio(){
        Menu menu = new Menu(null, true, false, false, central);
        moduloRelatorio = new ModuloRelatorio(menu, true, false, true, central);
        moduloRelatorio.setVisible(true);
        this.dispose();
    }
}
