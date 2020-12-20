package views.transacoes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import models.Transacao;

public class MostraTransacao extends javax.swing.JFrame {
	Transacao t;

	public MostraTransacao(Transacao t) {
		this.t = t;

		mostrar();

		setTitle("Consulta de dados");

		setSize(600, 400);

		setLocationRelativeTo(null);

		setVisible(true);
	}

	void mostrar() {
		JPanel painel = new JPanel();

		JLabel titulo = new JLabel("Dados da transação" + t.getId());
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("SansSerif", Font.PLAIN, 26));

		JTextArea textAreal = new JTextArea(t.mostrarExtrato());
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
