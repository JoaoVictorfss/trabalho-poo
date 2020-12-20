package views.conta;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import views.templates.Painel;
import views.templates.Menu;

public class TelaPrincipalConta extends JFrame {
	public TelaPrincipalConta() {
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

		Painel painelFuncionario = new Painel("Gerenciador de Contas");
		add(painelFuncionario, BorderLayout.NORTH);

		Menu menu = new Menu("Salvar conta(s)", "conta");
		add(menu, BorderLayout.CENTER);
	}

}