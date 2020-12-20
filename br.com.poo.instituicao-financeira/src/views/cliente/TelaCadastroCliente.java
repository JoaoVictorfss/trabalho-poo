package views.cliente;

import java.awt.BorderLayout;
import java.awt.Color;

import views.templates.Painel;

public class TelaCadastroCliente extends javax.swing.JFrame {
	public TelaCadastroCliente() {
		organizarLayout();

		setTitle("Cadastro de Clientes");

		// Tamanho da tela
		setSize(550, 760);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelCliente = new Painel("Cadastro de Clientes");
		add(painelCliente, BorderLayout.NORTH);

		FormCliente form = new FormCliente();
		add(form);
	}
}
