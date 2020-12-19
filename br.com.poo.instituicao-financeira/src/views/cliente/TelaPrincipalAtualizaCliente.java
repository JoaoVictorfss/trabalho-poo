package views.cliente;

import java.awt.BorderLayout;
import views.templates.Painel;

public class TelaPrincipalAtualizaCliente extends javax.swing.JFrame {

	public TelaPrincipalAtualizaCliente() {
		organizarLayout();

		setTitle("Atualização de Cliente");

		// Tamanho da tela
		setSize(400, 270);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Para finalizar a aplicação
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelCliente = new Painel("Atualização de Cliente");
		add(painelCliente, BorderLayout.NORTH);

		TelaBuscaCliente form = new TelaBuscaCliente();
		add(form);
	}
}
