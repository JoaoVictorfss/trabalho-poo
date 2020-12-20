package views.cliente;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import views.templates.Menu;
import views.templates.Painel;

public class TelaPrincipalCliente extends JFrame {
	public TelaPrincipalCliente() {
		organizarLayout();

		setTitle("Clientes");

		// Tamanho da tela
		setSize(500, 600);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);
	}

	private void organizarLayout() {
		setLayout(new BorderLayout());

		Painel painelCliente = new Painel("Gerenciador de clientes");
		add(painelCliente, BorderLayout.NORTH);

		Menu menu = new Menu("Salvar cliente(s)", "Cliente");
		add(menu, BorderLayout.CENTER);
	}
	
}
