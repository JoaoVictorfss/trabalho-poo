package views.cliente;

import java.awt.BorderLayout;

import views.templates.Painel;

public class TelaExcluiCliente extends javax.swing.JFrame{
	public TelaExcluiCliente () {
		organizarLayout();

		setTitle("Exclusão de Cliente");

		// Tamanho da tela
		setSize(400, 270);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelCliente = new Painel("Exclusão de Cliente");
		add(painelCliente, BorderLayout.NORTH);

		FormExcluiCliente form = new FormExcluiCliente();
		
		add(form);
	}

}


	