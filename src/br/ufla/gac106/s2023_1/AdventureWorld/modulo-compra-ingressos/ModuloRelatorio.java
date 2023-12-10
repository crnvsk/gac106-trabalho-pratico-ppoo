package br.ufla.gac106.s2023_1.AdventureWorld.compraIngressos;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao.Central;
import br.ufla.gac106.s2023_1.AdventureWorld.relatorios.ContabilizadorIngressos;
import br.ufla.gac106.s2023_1.AdventureWorld.relatorios.GraficoIngressos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class ModuloRelatorio extends Menu {
    
    public ModuloRelatorio(JanelaBase janelaAnterior, boolean temBotaoFinalizar, boolean temBotaoAvancar,
            boolean temBotaoVoltar, Central central) {
        super(janelaAnterior, temBotaoFinalizar, false, temBotaoVoltar, central);
    }

    @Override
    protected JPanel criarPainelCentral() {
        JPanel painelCentral = new JPanel();
        
        
        JButton botaoEvento1 = new JButton("Quantidade de ingressos vendidos e o valor arrecadado por evento");
        botaoEvento1.setPreferredSize(new Dimension(500, 50));
        JButton botaoEvento2 = new JButton("Quantidade de ingressos vendidos e o valor arrecadado por Atividade ");
        botaoEvento2.setPreferredSize(new Dimension(500, 50));
        JButton botaoEvento3 = new JButton("Quantidade de ingressos comprados e o valor arrecadado por Comprador.");
        botaoEvento3.setPreferredSize(new Dimension(500, 50));

        painelCentral.add(botaoEvento1);
        painelCentral.add(botaoEvento2);
        painelCentral.add(botaoEvento3);
        

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
        
        return painelCentral;
    }

    private void abrirProximaJanelaEvento1() {
        List<ContabilizadorIngressos> dados = central.getDadosIngressosPorParque();
        GraficoIngressos grafico = new GraficoIngressos();
        grafico.exibir("Parques", dados, false);
    }

    private void abrirProximaJanelaEvento2() {
        List<ContabilizadorIngressos> dados = central.getDadosIngressosPorAtividade();
        GraficoIngressos grafico = new GraficoIngressos();
        grafico.exibir("Visitas", dados, false);
    }

    private void abrirProximaJanelaEvento3() {
        List<ContabilizadorIngressos> dados = central.getDadosIngressosPorComprador();
        GraficoIngressos grafico = new GraficoIngressos();
        grafico.exibir("Compradores", dados, true);
    }


}
