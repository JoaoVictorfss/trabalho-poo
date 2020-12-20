package views.agencia;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import views.templates.Menu;
import views.templates.Painel;

public class TelaPrincipalAgencia extends JFrame {
	public TelaPrincipalAgencia() {
		organizarLayout();

		setTitle("Agencias");

		// Tamanho da tela
		setSize(500, 600);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);
	}

	private void organizarLayout() {
		setLayout(new BorderLayout());

		Painel painelAgencia = new Painel("Gerenciador de agencias");
		add(painelAgencia, BorderLayout.NORTH);

		Menu menu = new Menu("Salvar agencia(s)", "agencia");
		add(menu, BorderLayout.CENTER);
	}
}