package views.cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("SansSerif", Font.PLAIN, 26));

		JTextArea textAreal = new JTextArea(c.mostrarDados());
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
