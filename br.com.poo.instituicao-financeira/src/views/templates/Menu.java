package views.templates;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import views.cliente.MemoriaCliente;
import views.cliente.TelaCadastroCliente;
import views.cliente.TelaConsultaCliente;
import views.cliente.TelaPrincipalAtualizaCliente;

public class Menu extends JPanel {
	public Menu(String tipoOperacao, String tela) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));// 20 como valor na vertical e 40 na horizontal

		Botao cadastrar = adicionarBotao("Cadastrar");
		cadastrar.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cliente"))
				new TelaCadastroCliente();
		});
		add(cadastrar);

		Botao consultar = adicionarBotao("Consultar");
		consultar.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cliente"))
				new TelaConsultaCliente();
		});
		add(consultar);

		Botao atualizar = adicionarBotao("Atualizar");
		atualizar.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cliente"))
				new TelaPrincipalAtualizaCliente();
		});
		add(atualizar);

		Botao excluir = adicionarBotao("Excluir");
		excluir.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cliente"))
				new TelaExclui("Clientes");
		});
		add(excluir);

		Botao op = adicionarBotao(tipoOperacao);
		op.addActionListener(event -> {
			try {
				if (tela.equalsIgnoreCase("cliente"))
					MemoriaCliente.getInstancia().salvar();
				else if(tela.equalsIgnoreCase("funcionario"))
					return;
					//MemoriaFuncionario.getInstancia().salvar();
				else if(tela.equalsIgnoreCase("conta"))
					return;
						//MemoriaConta.getInstancia().salvar();
				else return;
					//MemoriaAgencia.getInstancia().salvar();				
					new Alerta("Sucesso. " + tela + "(s)" + " salvo(s)");
			} catch (RuntimeException e) {
				new Alerta(e.getMessage());
			}
		});
		add(op);
	}

	// Função que organiza o botão na tela, posicionando e adicionando o evento
	private Botao adicionarBotao(String texto) {
		Botao botao = new Botao(texto);
		botao.setPreferredSize(new Dimension(400, 50));
		return botao;
	}
}
