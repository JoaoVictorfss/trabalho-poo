package views.agencia;

import java.awt.BorderLayout;

import views.templates.Painel;

public class TelaCadastroAgencia extends javax.swing.JFrame {
	public TelaCadastroAgencia() {
		organizarLayout();

		setTitle("Cadastro de Agências");

		// Tamanho da tela
		setSize(540, 540);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelAgencia = new Painel("Cadastro de Agências");
		add(painelAgencia, BorderLayout.NORTH);

		FormAgencia form = new FormAgencia(this);
		add(form);
	}
}
