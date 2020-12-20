package views.conta;

import javax.swing.*;

import views.templates.Botao;

import java.awt.*;

public class FormContaSalario extends JPanel {

    public FormContaSalario() {
		setBackground(Color.WHITE);
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
        campoTarifa.setPreferredSize(new Dimension(110, 30));
        JLabel tarifa = adicionarLabel("Tarifa:");
        add(tarifa);
        add(campoTarifa);

        JTextField campoSalario = new JTextField();
        JLabel salario = adicionarLabel("Salário:");
        campoSalario.setPreferredSize(new Dimension(180, 30));
        add(salario);
        add(campoSalario);

        Botao botao = new Botao("Cadastrar");
        botao.setPreferredSize(new Dimension(140, 40));
        botao.setBackground(new Color(183, 158, 20));

        add(botao);
    }

    private JLabel adicionarLabel(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Courier", Font.BOLD, 16));
        return label;
    }
}