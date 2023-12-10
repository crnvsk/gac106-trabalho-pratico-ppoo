package br.ufla.gac106.s2023_1.AdventureWorld.compraIngressos;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;

import br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao.Central;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolhaAtividade extends ModuloADM {
    
    public EscolhaAtividade(ModuloADM janelaAnterior, Central central) {
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
        String nomeVisita = JOptionPane.showInputDialog("Digite o nome da Visita");
        if (central.verificaVisita(nomeVisita)) {
            JOptionPane.showMessageDialog(null, "Visita já cadastrada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            String nomeParque = JOptionPane.showInputDialog("Digite o nome do Parque");
            if (!central.verificaParque(nomeParque)) {
                JOptionPane.showMessageDialog(null, "Parque não existente..", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                String nomeCidade = JOptionPane.showInputDialog("Digite o nome da Cidade");
                if (!central.verificaCidade(nomeCidade)) {
                    JOptionPane.showMessageDialog(null, "Cidade não existente.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    String tipoIngresso = JOptionPane.showInputDialog("Digite o tipo de Ingresso (1 Para Normal / 2 Para Vip)");
                    String data = JOptionPane.showInputDialog("Digite a data da visita");
                    String horario = JOptionPane.showInputDialog("Digite o horario da visita");

                    central.cadastrarVisita(nomeVisita, central.obterParquePorNome(nomeParque),
                            central.obterCidadePorNome(nomeCidade), tipoIngresso, data, horario);
                }
            }
        }
    }

    private void fazerListagem(){
        String parque = JOptionPane.showInputDialog("Digite o nome do parque associado à visita que deseja listar");
        JOptionPane.showMessageDialog(null, central.listarVisitas(parque), "Listagem", JOptionPane.WARNING_MESSAGE);
    }

    private void mostrarDetalhes(){
        String visita = JOptionPane.showInputDialog("Digite o nome da visita que deseja detalhar");
        JOptionPane.showMessageDialog(null, central.detalharVisita(visita), "Detalhar", JOptionPane.WARNING_MESSAGE);
    }

    private void fazerRemocao(){
        String visita = JOptionPane.showInputDialog("Digite o nome da visita que deseja remover");
        System.out.println(central.removerVisita(visita));
        JOptionPane.showMessageDialog(null, "Visita removida!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
    }
}
