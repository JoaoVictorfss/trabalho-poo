package views.agencia;

import java.awt.BorderLayout;

import models.Agencia;
import views.templates.Painel;

public class TelaAtualizaAgencia extends javax.swing.JFrame {
	private Agencia c;

	public TelaAtualizaAgencia(Agencia agencia) {
		this.c = agencia;

		organizarLayout();

		setTitle("Atualização de Agencia");

		// Tamanho da tela
		setSize(540, 600);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelCliente = new Painel("Atualização de Agencia");
		add(painelCliente, BorderLayout.NORTH);

		FormAtualizaAgencia form = new FormAtualizaAgencia(this.c, this);
		add(form);
	}
}
