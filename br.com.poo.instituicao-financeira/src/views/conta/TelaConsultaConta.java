package views.conta;

import java.awt.BorderLayout;
import java.awt.Color;

import views.templates.Painel;
public class TelaConsultaConta extends javax.swing.JFrame{
	public TelaConsultaConta () {
		organizarLayout();

		setTitle("Consultar Conta");

		// Tamanho da tela
		setSize(400, 270);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelConta = new Painel("Consultar Conta");
		add(painelConta, BorderLayout.NORTH);

		TelaBuscaConta form = new TelaBuscaConta(true);
		
		add(form);
	}

}


	