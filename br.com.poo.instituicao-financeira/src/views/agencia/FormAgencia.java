package views.agencia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import views.Botao;

public class FormAgencia extends JPanel {

    public FormAgencia() {
        setBackground(new Color(220, 220, 220));
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        JTextField campoNroAgencia = new JTextField();
        campoNroAgencia.setPreferredSize(new Dimension(150, 30));
        JLabel nroConta = adicionarLabel("N° Agência:");
        add(nroConta);
        add(campoNroAgencia);

        JTextField campoNome = new JTextField();
        campoNome.setPreferredSize(new Dimension(120, 30));
        JLabel nome = adicionarLabel("Nome:");
        add(nome);
        add(campoNome);

        JTextField campoPais = new JTextField();
        campoPais.setPreferredSize(new Dimension(140, 30));
        JLabel pais = adicionarLabel("País:");
        add(pais);
        add(campoPais);

        JTextField campoUf = new JTextField();
        campoUf.setPreferredSize(new Dimension(150, 30));
        JLabel uf = adicionarLabel("Estado:");
        add(uf);
        add(campoUf);

        JTextField campoCep = new JTextField();
        campoCep.setPreferredSize(new Dimension(150, 30));
        JLabel cep = adicionarLabel("CEP:");
        add(cep);
        add(campoCep);

        JTextField campoCidade = new JTextField();
        campoCidade.setPreferredSize(new Dimension(150, 30));
        JLabel cidade = adicionarLabel("Cidade:");
        add(cidade);
        add(campoCidade);

        JTextField campoRua = new JTextField();
        campoRua.setPreferredSize(new Dimension(150, 30));
        JLabel rua = adicionarLabel("Rua:");
        add(rua);
        add(campoRua);

        JTextField campoNumero = new JTextField();
        campoNumero.setPreferredSize(new Dimension(150, 30));
        JLabel numero = adicionarLabel("Número:");
        add(numero);
        add(campoNumero);

        JTextField campoGerente = new JTextField();
        campoGerente.setPreferredSize(new Dimension(150, 30));
        JLabel gerente = adicionarLabel("Gerente:");
        add(gerente);
        add(campoGerente);


        Botao botao = new Botao("Cadastrar");
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
