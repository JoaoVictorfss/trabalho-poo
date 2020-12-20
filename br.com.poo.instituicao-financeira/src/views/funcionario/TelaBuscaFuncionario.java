package views.funcionario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import models.Cliente;
import models.Funcionario;
import views.templates.Alerta;
import views.templates.Botao;

public class TelaBuscaFuncionario extends JPanel {
    String label = "Atualizar";

    public TelaBuscaFuncionario(boolean telaBusca) {
        if(telaBusca) this.label = "Buscar";

        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        JLabel cpf = new JLabel("Cpf:");
        cpf.setFont(new Font("Courier", Font.BOLD, 16));
        add(cpf);

        JTextField campoCpf = new JTextField("52094901653");
        campoCpf.setPreferredSize(new Dimension(300, 30));
        add(campoCpf);

        Botao botao = new Botao(label);
        botao.setPreferredSize(new Dimension(150, 30));
        botao.setBackground(new Color(183, 158, 20));

        add(botao);

        botao.addActionListener(event -> {
            if (!campoCpf.getText().isEmpty()) {
                try {
                    Funcionario c = MemoriaFuncionario.getInstancia().buscaFuncionario(campoCpf.getText());
                    if (!telaBusca && verificaFuncionario(c))
                        new TelaAtualizaFuncionario(c);
                    else if (verificaFuncionario(c))
                        new MostraFuncionario(c);
                } catch (RuntimeException e) {
                    new Alerta("Erro." + e.getMessage());
                }
            } else {
                new Alerta("Erro. O campo é obrigatório.");
            }
        });

    }

    private boolean verificaFuncionario(Funcionario c) {
        if (c != null) {
            return true;
        } else {
            new Alerta("Erro. Funcionario inexistente");
            return false;
        }
    }
}
