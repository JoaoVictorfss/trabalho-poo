package views.transacoes;

import java.awt.BorderLayout;

import views.templates.Painel;

public class TelaConsultaTransacao extends javax.swing.JFrame {

	public TelaConsultaTransacao() {
		organizarLayout();

		setTitle("Consultar Transações");

		// Tamanho da tela
		setSize(400, 380);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelConta = new Painel("Consultar Conta");
		add(painelConta, BorderLayout.NORTH);

		FormBuscaTransacao form = new FormBuscaTransacao();
		add(form);
	}
}
