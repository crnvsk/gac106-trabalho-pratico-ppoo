package br.ufla.gac106.s2023_1.AdventureWorld.compraIngressos;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;

import br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao.Central;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolhaLocal extends ModuloADM {

    public EscolhaLocal(ModuloADM janelaAnterior, Central central) {
        super(janelaAnterior,true, true, true, central);
        janelaAnterior = moduloADM;
    }

    @Override
    protected JPanel criarPainelCentral() {
        JPanel painelCentral = new JPanel();

        JButton botaoEvento1 = new JButton("Cadastrar");
        JButton botaoEvento2 = new JButton("Listar");
        JButton botaoEvento3 = new JButton("Detalhar");
        JButton botaoEvento4 = new JButton("Remover");

        painelCentral.add(botaoEvento1);
        botaoEvento1.setPreferredSize(new Dimension(500, 50));
        painelCentral.add(botaoEvento2);
        botaoEvento2.setPreferredSize(new Dimension(500, 50));
        painelCentral.add(botaoEvento3);
        botaoEvento3.setPreferredSize(new Dimension(500, 50));
        painelCentral.add(botaoEvento4);
        botaoEvento4.setPreferredSize(new Dimension(500, 50));

        botaoEvento1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fazerCadastro();
            }
        });

        botaoEvento2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fazerListagem();
            }
        });

        botaoEvento3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mostrarDetalhes();
            }
        });

        botaoEvento4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fazerRemocao();
            }
        });
        
        return painelCentral;
    }

    private void fazerCadastro(){
        String nomeCidade = JOptionPane.showInputDialog("Digite o nome da Cidade");
        if (central.verificaCidade(nomeCidade)) {
            JOptionPane.showMessageDialog(null, "Local já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            String nomeEstado = JOptionPane.showInputDialog("Digite o nome da Estado");
            central.cadastrarCidade(nomeCidade, nomeEstado);
        }
    }

    private void fazerListagem(){
        JOptionPane.showMessageDialog(null, central.listarCidades(), "Listagem", JOptionPane.WARNING_MESSAGE);
    }

    private void mostrarDetalhes(){
        String nomeDetalhe = JOptionPane.showInputDialog("Digite o nome da Cidade que deseja detalhar");
        JOptionPane.showMessageDialog(null, central.detalharCidade(nomeDetalhe), "Detalhar", JOptionPane.WARNING_MESSAGE);
    }

    private void fazerRemocao(){
        String nomeLocalRemover = JOptionPane.showInputDialog("Digite o nome do local a ser removido");
        JOptionPane.showMessageDialog(null, central.removerCidade(nomeLocalRemover), "Remoção", JOptionPane.WARNING_MESSAGE);
    }
}
