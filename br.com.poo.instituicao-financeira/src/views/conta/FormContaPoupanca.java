package views.conta;

import views.Botao;

import javax.swing.*;
import java.awt.*;

public class FormContaPoupanca extends JPanel {

    public FormContaPoupanca() {
        setBackground(new Color(220, 220, 220));
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        setBackground(new Color(220, 220, 220));
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        JTextField campoNroConta = new JTextField();
        campoNroConta.setPreferredSize(new Dimension(150, 30));
        JLabel nroConta = adicionarLabel("N° Conta:");
        add(nroConta);
        add(campoNroConta);

        JTextField campoAgencia = new JTextField();
        campoAgencia.setPreferredSize(new Dimension(120, 30));
        JLabel agencia = adicionarLabel("N° Agência:");
        add(agencia);
        add(campoAgencia);

        JTextField campoCliente = new JTextField("000.000.000-00");
        campoCliente.setPreferredSize(new Dimension(150, 30));
        JLabel cliente = adicionarLabel("CPF Cliente:");
        add(cliente);
        add(campoCliente);

        JTextField campoStatus = new JTextField();
        campoStatus.setPreferredSize(new Dimension(120, 30));
        JLabel status = adicionarLabel("Status:");
        add(status);
        add(campoStatus);

        JTextField campoTarifa = new JTextField();
        campoTarifa.setPreferredSize(new Dimension(100, 30));
        JLabel tarifa = adicionarLabel("Tarifa:");
        add(tarifa);
        add(campoTarifa);

        JTextField campoRendimento = new JTextField();
        JLabel rendimento = adicionarLabel("Rendimento:");
        campoRendimento.setPreferredSize(new Dimension(170, 30));
        add(rendimento);
        add(campoRendimento);

        Botao botao = new Botao("Cadatrar");
        botao.setPreferredSize(new Dimension(140, 40));
        botao.setBackground(Color.BLUE);

        add(botao);
    }

    private JLabel adicionarLabel(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Courier", Font.BOLD, 16));
        return label;
    }
}