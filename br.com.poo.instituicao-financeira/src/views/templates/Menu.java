package views.templates;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import views.agencia.MemoriaAgencia;
import views.agencia.TelaCadastroAgencia;
import views.agencia.TelaConsultaAgencia;
import views.agencia.TelaPrincipalAtualizaAgencia;
import views.cliente.MemoriaCliente;
import views.cliente.TelaCadastroCliente;
import views.cliente.TelaConsultaCliente;
import views.cliente.TelaPrincipalAtualizaCliente;
import views.conta.*;
import views.funcionario.MemoriaFuncionario;
import views.funcionario.TelaCadastroFuncionario;
import views.funcionario.TelaConsultaFuncionario;
import views.funcionario.TelaPrincipalAtualizaFuncionario;

public class Menu extends JPanel {
	public Menu(String tipoOperacao, String tela) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));// 20 como valor na vertical e 40 na horizontal

		Botao cadastrar = adicionarBotao("Cadastrar");
		cadastrar.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cliente"))
				new TelaCadastroCliente();
			else if(tela.equalsIgnoreCase("funcionario"))
				new TelaCadastroFuncionario();
			else if(tela.equalsIgnoreCase("conta"))
				new TelaCadastroConta();
			else new TelaCadastroAgencia();
		});
		add(cadastrar);

		Botao consultar = adicionarBotao("Consultar");
		consultar.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cliente"))
				new TelaConsultaCliente();
			else if(tela.equalsIgnoreCase("conta"))
			   new TelaConsultaConta();
			else if(tela.equalsIgnoreCase("funcionario"))
				new TelaConsultaFuncionario();
			else new TelaConsultaAgencia();
		});
		add(consultar);

		Botao atualizar = adicionarBotao("Atualizar");
		atualizar.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cliente"))
				new TelaPrincipalAtualizaCliente();
			else if(tela.equalsIgnoreCase("conta"))
				new TelaPrincipalAtualizaConta();
			else if(tela.equalsIgnoreCase("funcionario"))
				new TelaPrincipalAtualizaFuncionario();
			else new TelaPrincipalAtualizaAgencia();

		});
		add(atualizar);

		Botao excluir = adicionarBotao("Excluir");
		excluir.addActionListener(event -> {
			if (tela.equalsIgnoreCase("cliente"))
				new TelaExclui("Clientes");
			else if(tela.equalsIgnoreCase("funcionario"))
				new TelaExclui("Funcionarios");
			else if(tela.equalsIgnoreCase("conta"))
				new TelaExclui("Contas");
			else
				new TelaExclui("Agencias");
		});
		add(excluir);

		Botao op = adicionarBotao(tipoOperacao);
		op.addActionListener(event -> {
			try {
				if (tela.equalsIgnoreCase("cliente"))
					MemoriaCliente.getInstancia().salvar();
				else if(tela.equalsIgnoreCase("funcionario"))
					MemoriaFuncionario.getInstancia().salvar();
				else if(tela.equalsIgnoreCase("conta"))
					MemoriaConta.getInstancia().salvar();
				else MemoriaAgencia.getInstancia().salvar();				
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
