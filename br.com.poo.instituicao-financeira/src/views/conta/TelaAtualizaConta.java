package views.conta;

import java.awt.BorderLayout;

import models.Conta;
import views.templates.Painel;

public class TelaAtualizaConta extends javax.swing.JFrame {
	private Conta c;

	public TelaAtualizaConta(Conta conta) {
		this.c = conta;

		organizarLayout();

		setTitle("Atualização de Contas");

		// Tamanho da tela
		setSize(550, 760);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelConta = new Painel("Atualização de Conta");
		add(painelConta, BorderLayout.NORTH);

		FormAtualizaConta form = new FormAtualizaConta(this.c, this);
		add(form);
	}
}
