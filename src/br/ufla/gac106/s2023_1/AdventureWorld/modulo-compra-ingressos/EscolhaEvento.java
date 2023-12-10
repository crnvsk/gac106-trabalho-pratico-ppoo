package br.ufla.gac106.s2023_1.AdventureWorld.compraIngressos;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;

import br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao.Central;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class EscolhaEvento extends ModuloADM {

    public EscolhaEvento(ModuloADM janelaAnterior, Central central) {
        super(janelaAnterior, true, true, true, central);
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
        String nomeParque = JOptionPane.showInputDialog("Digite o nome do Parque");
        if (central.verificaParque(nomeParque)) {
            JOptionPane.showMessageDialog(null, "Parque já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<String> listaAtracoes = lerAtracoesDoUsuario();
            central.cadastrarParque(nomeParque, listaAtracoes);
        }
    }

    private ArrayList<String> lerAtracoesDoUsuario() {
        ArrayList<String> listaStrings = new ArrayList<String>();

        String atracao = JOptionPane.showInputDialog("Digite as atrações (digite 'fim' para encerrar): ");

        while (!atracao.equalsIgnoreCase("fim")) {
            listaStrings.add(atracao); // Adiciona a atração à lista
            atracao = JOptionPane.showInputDialog("Digite as atrações (digite 'fim' para encerrar): ");
        }

        return listaStrings;
    }

    private void fazerListagem(){
        JOptionPane.showMessageDialog(null, central.listarParques(), "Listagem", JOptionPane.WARNING_MESSAGE);
    }

    private void mostrarDetalhes(){
        String nomeDetalhe = JOptionPane.showInputDialog("Digite o nome do Parque que deseja detalhar");
        JOptionPane.showMessageDialog(null, central.detalharParque(nomeDetalhe), "Detalhar", JOptionPane.WARNING_MESSAGE);
    }

    private void fazerRemocao(){
        String nomeParqueRemover = JOptionPane.showInputDialog("Digite o nome do parque a ser removido");
        JOptionPane.showMessageDialog(null, central.removerParque(nomeParqueRemover), "Remoção", JOptionPane.WARNING_MESSAGE);
    }
}
