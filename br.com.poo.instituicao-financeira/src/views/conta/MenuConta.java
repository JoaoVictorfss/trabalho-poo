package views.conta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import views.templates.*;

import javax.swing.JPanel;

public class MenuConta extends JPanel{
    
	public MenuConta(String tela) {	
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 30, 40));//20 como valor na vertical e 40 na horizontal
		
        Botao corrente = adicionarBotao("Conta Corrente");
        corrente.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cadastro"))
				new TelaCadastroContaCorr();
        });
        
        Botao poupanca = adicionarBotao("Conta Poupanca");
        poupanca.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cadastro"))
				new TelaCadastroContaPoup();
			else if(tela.equalsIgnoreCase("atualizar"))
				new TelaPrincipalAtualizaConta();
			else if(tela.equalsIgnoreCase("consultar"))
				new TelaConsultaConta();
        });
        
		Botao salario = adicionarBotao("Conta Salario");
        salario.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cadastro"))
				new TelaCadastroContaSal();
			else if(tela.equalsIgnoreCase("atualizar"))
				new TelaPrincipalAtualizaConta();
			else if(tela.equalsIgnoreCase("consultar"))
				new TelaConsultaConta();
		});
	}
	
	//Função que organiza o botão na tela, posicionando e adicionando o evento
	private Botao adicionarBotao(String texto) {
		Botao botao = new Botao(texto);
		botao.setPreferredSize(new Dimension(400, 50));
        add(botao);
        return botao;
	}
}
