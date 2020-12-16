package views.cliente;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import views.Menu;

public class TelaPrincipalCliente extends JFrame{

	public TelaPrincipalCliente(){
		organizarLayout();
		
		setTitle("Clientes");
				
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
		setLayout(new BorderLayout());
		
		PainelCliente painelCliente = new PainelCliente();
		
		add(painelCliente, BorderLayout.NORTH);//Painel fica no centro
		
	    Menu menu = new Menu();
		add(menu, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new TelaPrincipalCliente();
	}
}