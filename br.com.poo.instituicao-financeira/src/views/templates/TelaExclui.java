package views.templates;

import java.awt.BorderLayout;
import java.awt.Color;

public class TelaExclui extends javax.swing.JFrame{
	private String tipo;
	public TelaExclui (String tipo) {
		this.tipo = tipo;
		organizarLayout();

		setTitle("Exclusão de " + tipo);

		// Tamanho da tela
		setSize(400, 270);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelCliente = new Painel("Exclusão de " + tipo);
		add(painelCliente, BorderLayout.NORTH);

		if(tipo.equalsIgnoreCase("Clientes")) {
			FormExclui form = new FormExclui("Cliente","60792520076");
			add(form);
		}
		
		else if(tipo.equalsIgnoreCase("Funcionarios")) {
			FormExclui form = new FormExclui("Funcionario","52094901653");
			add(form);
		}
		
		else if(tipo.equalsIgnoreCase("Agencias")) {
			FormExclui form = new FormExclui("Agencia","0800");
			add(form);
		}
		
		else {
			FormExclui form = new FormExclui("Conta","12");
			add(form);
		}
		
	}

}


	