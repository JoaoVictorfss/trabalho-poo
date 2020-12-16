package views.cliente;

import java.awt.BorderLayout;

import views.Painel;


public class TelaCadastroCliente extends javax.swing.JFrame {
	
	public TelaCadastroCliente (){
		organizarLayout();
		
		setTitle("Cadastro de Clientes");
				
		//Tamanho da tela
		setSize(500, 600);
				
		//Aplicação abre no centro da tela
		setLocationRelativeTo(null);
		
		//Para finalizar a aplicação
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Fica Visível
		setVisible(true);
	}
	
	private void organizarLayout() {
		Painel painelCliente = new Painel("Cadastro de cliente");
		add(painelCliente, BorderLayout.NORTH);
		
	}  	
	
	public static void main(String[] args) {
		new TelaCadastroCliente();
	}
}

            
