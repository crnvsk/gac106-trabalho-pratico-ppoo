package br.ufla.gac106.s2023_1.AdventureWorld.compraIngressos;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;


import br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao.Central;
import br.ufla.gac106.s2023_1.AdventureWorld.relatorios.ContabilizadorIngressos;

public class DetalhesEvento extends ModuloCompraIngressos implements ContabilizadorIngressos{

    private String selecao;
    private JTextArea areaTextoAtividades;
    private JButton botaoComprar;
    private int quantidade;
    private int meiaEntrada;
    private int total;
    private String nomeComprador;

    public DetalhesEvento(JanelaBase janelaAnterior, Central central, String selecao) {
        super(janelaAnterior, true, false, true, central);
        this.selecao = selecao;
        atualizarArea();
    }

    @Override
    protected JPanel criarPainelCentral() {

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new FlowLayout(FlowLayout.LEFT));
        botaoComprar = new JButton("Comprar");
        areaTextoAtividades = new JTextArea();
        painelCentral.add(areaTextoAtividades);

        areaTextoAtividades.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
        areaTextoAtividades.setEditable(false);

        painelCentral.add(botaoComprar);
        botaoComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fazerCompra();
            }
        });

        return painelCentral;
    }

    private void atualizarArea() {
        areaTextoAtividades.setText(central.detalharVisitaCompleta(selecao, total, nomeComprador));
    }

    private void fazerCompra() {
        // Criar campos de entrada para quantidade e nome do comprador
        JTextField nomeCompradorField = new JTextField();
        JTextField quantidadeField = new JTextField();
        JTextField meiaEntradaField = new JTextField();

        Object[] mensagem = {
            "Digite seu nome:", nomeCompradorField,
            "Quantos ingressos inteiros deseja comprar?", quantidadeField,
            "Quantos ingressos meia-entrada deseja comprar?", meiaEntradaField
        };

        int opcao = JOptionPane.showConfirmDialog(null, mensagem, "Compra de Ingressos",
                JOptionPane.OK_CANCEL_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            // Obter os valores inseridos nos campos de entrada
            this.nomeComprador = nomeCompradorField.getText();
            String quantidadeString = quantidadeField.getText();
            String meiaEntradaString = meiaEntradaField.getText();
            colocarNomeComprador();
            
            try {
                quantidade = Integer.parseInt(quantidadeString);
                this.meiaEntrada = Integer.parseInt(meiaEntradaString);

                double precoTotal = ((central.precoVisita(selecao) * quantidade) + (central.precoVisita(selecao) * meiaEntrada/2)) * 1.2;

                this.total = quantidade + this.meiaEntrada;

                if (central.checaVenda(selecao, this.total)) {
                    int confirmacao = JOptionPane.showConfirmDialog(null,
                            "Sr." + nomeComprador + ", o total da sua compra é R$" + precoTotal,
                            "Confirmação", JOptionPane.YES_NO_OPTION);

                    if (confirmacao == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!",
                                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        //atualizarArea(); tava dando erro
                        areaTextoAtividades.setText(central.detalharVisitaCompleta(selecao, total, nomeComprador));
                        central.gerarPDF(selecao, quantidade, meiaEntrada, precoTotal, nomeComprador);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Quantidade de ingressos indisponível.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida. Digite um número inteiro.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void colocarNomeComprador(){
        central.colocarNomeComprador(nomeComprador);
    }


    @Override
    public String identificador() {
        return selecao;
    }
    

    @Override
    public int quantidadeIngressos() {
        return quantidade;
    }

    @Override
    public double valorTotal() {
        return (quantidade * central.precoVisita(selecao) );
    }
}