package views.conta;

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

import models.Conta;

public class MostraConta extends javax.swing.JFrame {
	Conta c;

	public MostraConta(Conta c) {
		this.c = c;
		mostrar();

		setTitle("Consulta de dados");

		setSize(600, 400);

		setLocationRelativeTo(null);

		setVisible(true);
	}

	void mostrar() {
		JPanel painel = new JPanel();

		JLabel titulo = new JLabel("Dados da conta " + c.getNroConta());
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("SansSerif", Font.PLAIN, 26));

		final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		final String dataAber = formato.format(c.getDataAbertura());

		final String text ="Número da Conta:  "+ c.getStatus() + ".\n" + "Data de Abertura: " + dataAber 
		+ ".\n" + ".\n";

		JTextArea textAreal = new JTextArea(text);
		textAreal.setPreferredSize(new Dimension(550, 300));
		textAreal.setLineWrap(true);
		textAreal.setWrapStyleWord(true);
		textAreal.setFont(new Font("Serif", Font.BOLD, 20));

		painel.setBackground(new Color(229, 197, 25));

		painel.add(titulo);
		painel.add(textAreal);
		add(painel);
	}

}
