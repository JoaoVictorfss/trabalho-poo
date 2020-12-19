package views.cliente;

import java.awt.BorderLayout;

import models.Cliente;
import views.templates.Painel;

public class TelaAtualizaCliente extends javax.swing.JFrame {
	private Cliente c;

	public TelaAtualizaCliente(Cliente cliente) {
		this.c = cliente;
		
		organizarLayout();

		setTitle("Atualização de Clientes");

		// Tamanho da tela
		setSize(550, 760);

		// Aplicação abre no centro da tela
		setLocationRelativeTo(null);

		// Fica Visível
		setVisible(true);

	}

	void organizarLayout() {
		Painel painelCliente = new Painel("Atualização de Cliente");
		add(painelCliente, BorderLayout.NORTH);

		FormAtualizaCliente form = new FormAtualizaCliente(this.c);
		add(form);
	}
}
