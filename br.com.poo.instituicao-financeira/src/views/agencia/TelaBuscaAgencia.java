package views.agencia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import models.Agencia;
import models.Cliente;
import views.templates.Alerta;
import views.templates.Botao;

public class TelaBuscaAgencia extends JPanel {
    String label = "Atualizar";

    public TelaBuscaAgencia(boolean telaBusca) {
        if(telaBusca) this.label = "Buscar";

        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        JLabel nroAgencia = new JLabel("Nro Agencia:");
        nroAgencia.setFont(new Font("Courier", Font.BOLD, 16));
        add(nroAgencia);

        JTextField campoNroAgencia = new JTextField("0800");
        campoNroAgencia.setPreferredSize(new Dimension(300, 30));
        add(campoNroAgencia);

        Botao botao = new Botao(label);
        botao.setPreferredSize(new Dimension(150, 30));
        botao.setBackground(new Color(183, 158, 20));

        add(botao);

        botao.addActionListener(event -> {
            if (!campoNroAgencia.getText().isEmpty()) {
                try {
                    Agencia c = MemoriaAgencia.getInstancia().buscaAgencias(campoNroAgencia.getText());
                    if (!telaBusca && verificaAgencia(c))
                        new TelaAtualizaAgencia(c);
                    else if (verificaAgencia(c))
                        new MostraAgencia(c);
                } catch (RuntimeException e) {
                    new Alerta("Erro." + e.getMessage());
                }
            } else {
                new Alerta("Erro. O campo é obrigatório.");
            }
        });

    }

    private boolean verificaAgencia(Agencia c) {
        if (c != null) {
            return true;
        } else {
            new Alerta("Erro. Agencia inexistente");
            return false;
        }
    }
}
