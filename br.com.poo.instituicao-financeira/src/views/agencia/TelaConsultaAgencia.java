package views.agencia;

import java.awt.BorderLayout;

import views.templates.Painel;

public class TelaConsultaAgencia extends javax.swing.JFrame {
	public TelaConsultaAgencia() {
		organizarLayout();

		setTitle("Consultar Agencia");

		// Tamanho da tela
		setSize(400, 350);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelAgencia = new Painel("Consultar Agencia");
		add(painelAgencia, BorderLayout.NORTH);

		TelaBuscaAgencia form = new TelaBuscaAgencia(true);
		add(form);
	}

}
