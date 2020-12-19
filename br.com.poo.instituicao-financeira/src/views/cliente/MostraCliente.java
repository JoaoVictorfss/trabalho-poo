package views.cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.Cliente;

public class MostraCliente extends javax.swing.JFrame {
	Cliente c;

	public MostraCliente(Cliente c) {
		this.c = c;
		mostrar();

		setTitle("Consulta de dados");

		setSize(600, 400);

		setLocationRelativeTo(null);

		setVisible(true);
	}

	void mostrar() {
		JPanel painel = new JPanel();

		JLabel titulo = new JLabel("Dados do " + c.getNome());
		titulo.setForeground(new Color(28, 28, 28));
		titulo.setFont(new Font("SansSerif", Font.PLAIN, 26));

		final String endereco = c.getEndereco().getCidade() + ", " + c.getEndereco().getRua() + ", "
				+ c.getEndereco().getNumero() + " - " + c.getEndereco().getUf() + ", " + c.getEndereco().getCep() + "("
				+ c.getEndereco().getPais() + ").\n";

		final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		final String dataNasc = formato.format(c.getDataNasc());

		final String text = "Nome:" + c.getNome() + ".\n" + "CPF: " + c.getCpf() + ".\n" + "Quantidade de conta(s):  "
				+ c.getContas().size() + ".\n" + "Endereço: " + endereco + "Estado Civil: " + c.getEstadoCivil() + ".\n"
				+ "Data de Nascimento: " + dataNasc + ".\n" + "Escolaridade: " + c.getEscolaridade() + ".\n";

		JTextArea textAreal = new JTextArea(text);
		textAreal.setPreferredSize(new Dimension(550, 300));
		textAreal.setLineWrap(true);
		textAreal.setWrapStyleWord(true);
		textAreal.setFont(new Font("Serif", Font.BOLD, 20));

		painel.setBackground(new Color(173, 216, 230));

		painel.add(titulo);
		painel.add(textAreal);
		add(painel);
	}

}
