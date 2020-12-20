package views.conta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Conta;
import views.templates.Alerta;
import views.templates.Botao;

public class TelaBuscaConta extends JPanel {
	String label = "Atualizar";

	public TelaBuscaConta(boolean telaBusca) {
		if (telaBusca)
			this.label = "Buscar";

		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

		JLabel nroConta = new JLabel("Nro Conta:");
		nroConta.setFont(new Font("Courier", Font.BOLD, 16));
		add(nroConta);

		JTextField campoNro = new JTextField("12");
		campoNro.setPreferredSize(new Dimension(300, 30));
		add(campoNro);

		Botao botao = new Botao(label);
		botao.setPreferredSize(new Dimension(150, 30));
		botao.setBackground(new Color(183, 158, 20));

		add(botao);

		botao.addActionListener(event -> {
			if (!campoNro.getText().isEmpty()) {
				try {
					Conta c = MemoriaConta.getInstancia().buscaConta(campoNro.getText());
					if (!telaBusca && verificaConta(c))
						new TelaAtualizaConta(c);
					else if (verificaConta(c))
						new MostraConta(c);
				} catch (RuntimeException e) {
					new Alerta("Erro." + e.getMessage());
				}
			} else {
				new Alerta("Erro. O campo é obrigatório.");
			}
		});

	}

	private boolean verificaConta(Conta c) {
		if (c != null) {
			return true;
		} else {
			new Alerta("Erro. Conta inexistente");
			return false;
		}
	}
}
