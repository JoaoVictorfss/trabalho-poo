package views.conta;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import views.templates.Painel;

public class TelaCadastroConta extends JFrame {
	public TelaCadastroConta() {
		organizarLayout();

		setTitle("Contas");

		// Tamanho da tela
		setSize(500, 600);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);
	}

	private void organizarLayout() {
		setLayout(new BorderLayout());

		Painel painelFuncionario = new Painel("Cadastro de Contas");
		add(painelFuncionario, BorderLayout.NORTH);

		MenuConta menuConta = new MenuConta("Cadastro");
		add(menuConta, BorderLayout.CENTER);
	}
}