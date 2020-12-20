package views.conta;

import javax.swing.*;

import models.Agencia;
import models.ContaPoupanca;
import views.agencia.MemoriaAgencia;
import views.templates.Alerta;
import views.templates.Botao;

import java.awt.*;

public class FormContaPoupanca extends JPanel {
	private int nroConta;
	private String status;
	private double rendimento;
	private double tarifa;
	private String agencia;

	private JFrame telaAnt;
	private boolean valido = true;

	public FormContaPoupanca(JFrame telaAtualiza) {
		this.telaAnt = telaAtualiza;

		JTextField campoNroConta = new JTextField("13");
		campoNroConta.setPreferredSize(new Dimension(150, 30));
		JLabel nroConta = adicionarLabel("N° Conta:");
		add(nroConta);
		add(campoNroConta);

		JTextField campoAgencia = new JTextField("0800");
		campoAgencia.setPreferredSize(new Dimension(120, 30));
		JLabel agencia = adicionarLabel("N° Agência:");
		add(agencia);
		add(campoAgencia);

		JTextField campoRendimento = new JTextField("8.2");
		campoRendimento.setPreferredSize(new Dimension(140, 30));
		JLabel rendimento = adicionarLabel("Rendimento:");
		add(rendimento);
		add(campoRendimento);

		JTextField campoTarifa = new JTextField("0.9");
		campoTarifa.setPreferredSize(new Dimension(140, 30));
		JLabel tarifa = adicionarLabel("Tarifa:");
		add(tarifa);
		add(campoTarifa);

		JTextField campoStatus = new JTextField("A");
		campoStatus.setPreferredSize(new Dimension(120, 30));
		JLabel status = adicionarLabel("Status:");
		add(status);
		add(campoStatus);

		Botao botao = new Botao("Cadastrar");
		botao.setPreferredSize(new Dimension(140, 40));
		botao.setBackground(new Color(183, 158, 20));

		add(botao);

		botao.addActionListener(event -> {

			if (naoVazio(campoNroConta.getText()))
				this.nroConta = transformaNumero(campoNroConta.getText());
			if (naoVazio(campoAgencia.getText()))
				this.agencia = campoAgencia.getText();
			if (naoVazio(campoStatus.getText()))
				this.status = campoStatus.getText();
			if (naoVazio(campoRendimento.getText()))
				this.rendimento = transformaStrDouble(campoRendimento.getText());
			if (naoVazio(campoTarifa.getText()))
				this.tarifa = transformaStrDouble(campoTarifa.getText());

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
			ContaPoupanca conta = null;

			Agencia ag = MemoriaAgencia.getInstancia().buscaAgencias(agencia);

			if (ag != null) {
				conta = new ContaPoupanca(rendimento, nroConta, ag, "A", tarifa);
			} else {
				throw new RuntimeException("Agencia não encontrada.");
			}

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
}