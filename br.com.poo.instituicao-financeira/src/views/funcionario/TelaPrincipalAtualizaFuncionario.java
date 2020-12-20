package views.funcionario;

import java.awt.BorderLayout;

import views.templates.Painel;

public class TelaPrincipalAtualizaFuncionario extends javax.swing.JFrame {

	public TelaPrincipalAtualizaFuncionario() {
		organizarLayout();

		setTitle("Atualização de Funcionario");

		// Tamanho da tela
		setSize(400, 270);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelFuncionario = new Painel("Atualização de Funcionario");
		add(painelFuncionario, BorderLayout.NORTH);

		TelaBuscaFuncionario form = new TelaBuscaFuncionario(false);
		add(form);
	}
}
