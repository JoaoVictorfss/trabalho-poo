package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import views.agencia.TelaPrincipalAgencia;
import views.cliente.TelaPrincipalCliente;
import views.conta.TelaPrincipalConta;
import views.funcionario.TelaPrincipalFuncionario;
import views.templates.Painel;

public class TelaPrincipal extends JFrame {
	public TelaPrincipal() {
		organizarLayout();

		setTitle("Instituição financeira");

		// Tamanho da tela
		setSize(500, 520);

		setLocationRelativeTo(null);

		//finaliza a aplicação
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Fica Visível
		setVisible(true);
	}

	private void organizarLayout() {
		setLayout(new BorderLayout());

		Painel painelCliente = new Painel("Gold Wallet");	
		add(painelCliente, BorderLayout.NORTH);
		
		JPanel opcoes = new JPanel();
		opcoes.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));// 20 como valor na vertical e 40 na horizontal
        
		JButton contas = adicionarBotao("Contas");
		contas.addActionListener(event -> { new TelaPrincipalConta();});
		opcoes.add(contas);
		
		JButton clientes = adicionarBotao("Clientes");
		clientes.addActionListener(event -> {new TelaPrincipalCliente();});
		opcoes.add(clientes);
		
		JButton funcionarios = adicionarBotao("Funcionários");
		funcionarios.addActionListener(event -> { new TelaPrincipalFuncionario();});
		opcoes.add(funcionarios);
		
		JButton agencias = adicionarBotao("Agências");
		agencias.addActionListener(event -> { new TelaPrincipalAgencia();});
		opcoes.add(agencias);
		
		add(opcoes);	
	}
	
    private JButton adicionarBotao(String texto) {
    	JButton botao = new JButton(texto);
		botao.setFont(new Font("courier", Font.PLAIN, 22));
		botao.setOpaque(true);
		botao.setBackground(new Color(229, 197, 25));
		botao.setForeground(Color.WHITE);
		botao.setBorder(BorderFactory.createBevelBorder(0));
    	botao.setPreferredSize(new Dimension(400, 50));
    	return botao;
    }
	
    public static void main(String[] args) {
        new TelaPrincipal();
    }
   
}
