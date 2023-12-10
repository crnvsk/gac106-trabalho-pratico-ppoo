package br.ufla.gac106.s2023_1.AdventureWorld.compraIngressos;
import br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao.Central;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class ModuloCompraIngressos extends Menu {

    private JTextPane areaTextoAtividades;
    private JScrollPane barraScroll;
    protected String selecao;

    public ModuloCompraIngressos(JanelaBase janelaAnterior, boolean temBotaoFinalizar, boolean temBotaoAvancar,
            boolean temBotaoVoltar, Central central) {
        super(janelaAnterior, temBotaoFinalizar, false, temBotaoVoltar, central);
    }

    @Override
    protected JPanel criarPainelCentral() {

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));

        areaTextoAtividades = new JTextPane();
        barraScroll = new JScrollPane(areaTextoAtividades);

        areaTextoAtividades.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
        areaTextoAtividades.setEditable(false);

        painelCentral.add(barraScroll);

        atualizarArea();

        return painelCentral;
    }

    private void atualizarArea() {
        areaTextoAtividades.setText("");
        central = new Central();
        central.carregarDados("dados.bin");
        List<String> visitasAuxiliar;
        visitasAuxiliar = central.returnVisitas();

        for (String x : visitasAuxiliar) {
            JButton button = new JButton(x);
            button.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selecao = x;
                    aoAvancar();
                }
            });

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            panel.add(button);
            panel.add(Box.createHorizontalStrut(10));

            areaTextoAtividades.insertComponent(panel);
            areaTextoAtividades.insertComponent(Box.createVerticalStrut(10));
        }
    }

    @Override
    public boolean aoAvancar() {
        DetalhesEvento detalhesEvento = new DetalhesEvento(this, central, selecao);
        detalhesEvento.setVisible(true);
        this.dispose();
        return true;
    }
}
