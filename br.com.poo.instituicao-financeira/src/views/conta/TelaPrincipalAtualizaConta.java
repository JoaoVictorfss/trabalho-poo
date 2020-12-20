package views.conta;

import java.awt.BorderLayout;
import java.awt.Color;

import views.templates.Painel;
public class TelaPrincipalAtualizaConta extends javax.swing.JFrame {

	public TelaPrincipalAtualizaConta() {
		organizarLayout();

		setTitle("Atualização de Conta");

		// Tamanho da tela
		setSize(400, 380);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelCliente = new Painel("Atualização de Cliente");
		add(painelCliente, BorderLayout.NORTH);

		TelaBuscaConta form = new TelaBuscaConta(false);
		add(form);
	}
}

