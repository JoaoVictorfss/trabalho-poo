package views.transacoes;

import java.awt.BorderLayout;

import views.templates.Painel;

public class TelaEfetuarTransacao extends javax.swing.JFrame {
	private String op;

	public TelaEfetuarTransacao(String op) {
		this.op = op;

		organizarLayout();

		setTitle("Efetuar transação");

		setSize(500, 450);

		setLocationRelativeTo(null);

		setVisible(true);
	}

	void organizarLayout() {
		Painel painel = new Painel("Efetuar " + op);
		add(painel, BorderLayout.NORTH);
		if (op.equalsIgnoreCase("transferencia")) {
			FormTransferencia form = new FormTransferencia(this);
			add(form);
		} else {
			FormTransacao form = new FormTransacao(op, this);
			add(form);
		}
	}
}
