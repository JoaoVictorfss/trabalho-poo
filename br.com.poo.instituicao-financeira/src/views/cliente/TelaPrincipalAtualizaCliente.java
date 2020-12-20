package views.cliente;

import java.awt.BorderLayout;
import java.awt.Color;

import views.templates.Painel;

public class TelaPrincipalAtualizaCliente extends javax.swing.JFrame {

	public TelaPrincipalAtualizaCliente() {
		organizarLayout();

		setTitle("Atualização de Cliente");

		// Tamanho da tela
		setSize(400, 270);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelCliente = new Painel("Atualização de Cliente");
		add(painelCliente, BorderLayout.NORTH);

		TelaBuscaCliente form = new TelaBuscaCliente(false);
		add(form);
	}
}
