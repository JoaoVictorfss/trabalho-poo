package views.funcionario;

import java.awt.BorderLayout;

import views.templates.Painel;

public class TelaConsultaFuncionario extends javax.swing.JFrame {
	public TelaConsultaFuncionario() {
		organizarLayout();

		setTitle("Consultar Funcionario");

		// Tamanho da tela
		setSize(400, 270);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelFuncionario = new Painel("Consultar Funcionario");
		add(painelFuncionario, BorderLayout.NORTH);

		TelaBuscaFuncionario form = new TelaBuscaFuncionario(true);

		add(form);
	}

}
