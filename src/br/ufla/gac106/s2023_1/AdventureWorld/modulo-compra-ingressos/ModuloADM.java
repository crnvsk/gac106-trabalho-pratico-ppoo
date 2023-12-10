package br.ufla.gac106.s2023_1.AdventureWorld.compraIngressos;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;

import br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao.Central;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModuloADM extends Menu {


    public ModuloADM(JanelaBase janelaAnterior, boolean temBotaoFinalizar, boolean temBotaoAvancar, boolean temBotaoVoltar, Central central) {
        super(janelaAnterior, true, false, true, central);
    }

    @Override
    protected JPanel criarPainelCentral() {
        JPanel painelCentral = new JPanel();
        
        
        JButton botaoEvento1 = new JButton("Administrar Eventos");
        botaoEvento1.setPreferredSize(new Dimension(500, 50));
        JButton botaoEvento2 = new JButton("Administrar Locais");
        botaoEvento2.setPreferredSize(new Dimension(500, 50));
        JButton botaoEvento3 = new JButton("Administrar Atividades");
        botaoEvento3.setPreferredSize(new Dimension(500, 50));
        JButton botaoEvento4 = new JButton("Apagar todos os Dados");
        botaoEvento4.setPreferredSize(new Dimension(500, 50));
        
        painelCentral.add(botaoEvento1);
        painelCentral.add(botaoEvento2);
        painelCentral.add(botaoEvento3);
        painelCentral.add(botaoEvento4);
        

        botaoEvento1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                abrirProximaJanelaEvento1();
            }
        });

        botaoEvento2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                abrirProximaJanelaEvento2();
            }
        });

        botaoEvento3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                abrirProximaJanelaEvento3();
            }
        });

        botaoEvento4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                apagarDados();
            }
        });
        
        return painelCentral;
    }

    private void abrirProximaJanelaEvento1() {
        moduloADM = new ModuloADM(moduloADM, true, false, false, central);
        EscolhaEvento escolhaEvento = new EscolhaEvento(this, central);
        escolhaEvento.setVisible(true);
        this.dispose();
    }

    private void abrirProximaJanelaEvento2() {
        moduloADM = new ModuloADM(moduloADM, true, false, false, central);
        EscolhaLocal escolhaLocal = new EscolhaLocal(this, central);
        escolhaLocal.setVisible(true);
        this.dispose();
    }

    private void abrirProximaJanelaEvento3() {
        moduloADM = new ModuloADM(moduloADM, true, false, false, central);
        EscolhaAtividade escolhaAtividade = new EscolhaAtividade(this, central);
        escolhaAtividade.setVisible(true);
        this.dispose();
    }
    
    private void apagarDados(){
        String confirmacao = JOptionPane.showInputDialog("Digite 'sim' para apagar os dados");
        if (confirmacao.toLowerCase().equals("sim")){
            JOptionPane.showMessageDialog(null, "Os dados foram apagados!", "Dados", JOptionPane.WARNING_MESSAGE);
            central.limparDados();
        }else{
            JOptionPane.showMessageDialog(null, "Os dados foram mantidos!", "Dados", JOptionPane.WARNING_MESSAGE);
        }
    }
}
