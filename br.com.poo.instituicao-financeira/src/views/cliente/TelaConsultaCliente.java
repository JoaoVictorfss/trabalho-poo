package views.cliente;

import java.awt.BorderLayout;
import java.awt.Color;

import views.templates.Painel;

public class TelaConsultaCliente extends javax.swing.JFrame{
	public TelaConsultaCliente () {
		organizarLayout();

		setTitle("Consultar Cliente");

		// Tamanho da tela
		setSize(400, 270);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelCliente = new Painel("Consultar Cliente");
		add(painelCliente, BorderLayout.NORTH);

		TelaBuscaCliente form = new TelaBuscaCliente(true);
		
		add(form);
	}

}


	