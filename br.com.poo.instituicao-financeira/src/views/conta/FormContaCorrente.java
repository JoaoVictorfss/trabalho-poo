package views.conta;

import javax.swing.*;

import views.agencia.MemoriaAgencia;
import views.templates.Alerta;
import views.templates.Botao;

import java.awt.*;

import models.*;

public class FormContaCorrente extends JPanel {

	private String categoria;
	private int nroConta;
	private String agencia;
	private String status;
	private double limite;

	private boolean valido = true;
	private JFrame telaAnt;

	public FormContaCorrente(JFrame telaAtualiza) {
		this.telaAnt = telaAtualiza;

		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

		JTextField campoNroConta = new JTextField("12");
		campoNroConta.setPreferredSize(new Dimension(150, 30));
		JLabel nroConta = adicionarLabel("N° Conta:");
		add(nroConta);
		add(campoNroConta);

		JTextField campoAgencia = new JTextField("0800");
		campoAgencia.setPreferredSize(new Dimension(120, 30));
		JLabel agencia = adicionarLabel("N° Agência:");
		add(agencia);
		add(campoAgencia);

		JTextField campoStatus = new JTextField("A");
		campoStatus.setPreferredSize(new Dimension(120, 30));
		JLabel status = adicionarLabel("Status:");
		add(status);
		add(campoStatus);

		JTextField campoCategoria = new JTextField("Standard");
		JLabel categoria = adicionarLabel("Categoria:");
		campoCategoria.setPreferredSize(new Dimension(170, 30));
		add(categoria);
		add(campoCategoria);

		JTextField campoLimite = new JTextField("20000");
		campoLimite.setPreferredSize(new Dimension(110, 30));
		JLabel limite = adicionarLabel("limite:");
		add(limite);
		add(campoLimite);

		Botao botao = new Botao("Cadastrar");
		botao.setPreferredSize(new Dimension(140, 40));
		botao.setBackground(new Color(183, 158, 20));

		add(botao);

		botao.addActionListener(event -> {

			if (naoVazio(campoCategoria.getText()))
				this.categoria = campoCategoria.getText();
			if (naoVazio(campoNroConta.getText()))
				this.nroConta = transformaNumero(campoNroConta.getText());
			if (naoVazio(campoAgencia.getText()))
				this.agencia = campoAgencia.getText();
			if (naoVazio(campoStatus.getText()))
				this.status = campoStatus.getText();
			if (naoVazio(campoLimite.getText()))
				this.limite = transformaStrDouble(campoLimite.getText());

			if (this.valido) {
				cadastraConta();
			} else {
				new Alerta("Dados incorretos. Tente novamente!");
				this.telaAnt.dispose();
			}
		});
	}

	@SuppressWarnings("unused")
	private void cadastraConta() {
		try {
			ContaCorrente conta = null;
			Agencia ag = MemoriaAgencia.getInstancia().buscaAgencias(agencia);

			if (ag != null) {
				conta = new ContaCorrente(categoria, nroConta, ag, status, limite);
			} else
				throw new RuntimeException("Agencia não encontrada.");

			if (conta == null) {
				new Alerta("Erro. Dados incorretos! Verique todos e tente novamente");
			} else {
				MemoriaConta.getInstancia().adicionarConta(conta);
				ag.setConta(conta);
				new Alerta("Sucesso. Dados cadastrados!");
			}
		} catch (RuntimeException e) {
			new Alerta("Erro." + e.getMessage());
		}
	}

	private JLabel adicionarLabel(String labelText) {
		JLabel label = new JLabel(labelText);
		label.setFont(new Font("Courier", Font.BOLD, 16));
		return label;
	}

	// Verifica se o campo está naoVazio
	private boolean naoVazio(String campo) {
		if (!campo.isEmpty()) {
			this.valido = this.valido && true;
			return true;
		} else {
			this.valido = false;
			return false;
		}
	}

	private int transformaNumero(String nro) {
		try {
			int numeroConvertido = Integer.parseInt(nro);

			this.valido = this.valido && true;
			return numeroConvertido;
		} catch (NumberFormatException e) {
			this.valido = false;
			new Alerta("Erro ao converter de string para número. Verifique o campo preenchido!");
			return -1;
		}
	}

	// converte para double
	private double transformaStrDouble(String n) {
		try {
			double numeroConvertido = Double.parseDouble(n);

			this.valido = this.valido && true;
			return numeroConvertido;
		} catch (NumberFormatException e) {
			this.valido = false;
			new Alerta("Erro ao converter de string para Double. Verifique o campo preenchido!");
			return -1;
		}
	}

}