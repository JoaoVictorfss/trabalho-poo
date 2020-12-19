package views.agencia;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import views.Painel;

public class TelaCadastroAgencia extends JFrame {
    public TelaCadastroAgencia() {
		organizarLayout();

		setTitle("Cadastro de Agências");

		// Tamanho da tela
		setSize(540, 540);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Para finalizar a aplicação
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelAgencia = new Painel("Cadastro de Agências");
		add(painelAgencia, BorderLayout.NORTH);

		FormAgencia form = new FormAgencia();
		add(form);

	}

	public static void main(String[] args) {
		new TelaCadastroAgencia();
	}
}
