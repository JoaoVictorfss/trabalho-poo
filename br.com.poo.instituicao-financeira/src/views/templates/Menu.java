package views.templates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.JPanel;

public class Menu extends JPanel{
    
	public Menu(String tipoOperacao) {	
		setBackground(Color.GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));//20 como valor na vertical e 40 na horizontal
		
		adicionarBotao("Cadastrar");
		adicionarBotao("Listar");
		adicionarBotao("Atualizar");
		adicionarBotao("Excluir");
		adicionarBotao(tipoOperacao);
	}
	
	//Função que organiza o botão na tela, posicionando e adicionando o evento
	private void adicionarBotao(String texto) {
		Botao botao = new Botao(texto);
		botao.setPreferredSize(new Dimension(400, 50));
		add(botao);
	}
}
