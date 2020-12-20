package views.transacoes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Agencia;
import models.Conta;
import models.Transacao;
import views.agencia.MemoriaAgencia;
import views.conta.MemoriaConta;
import views.templates.Alerta;
import views.templates.Botao;

public class FormTransferencia extends JPanel {
	private String nroAgencia;
	private String nroConta;
	private String nroContaDes;
	private double valor;
	private boolean valido = true;

	private JFrame telaAnt;

	public FormTransferencia(JFrame telaCadastro) {
		this.telaAnt = telaCadastro;
		
		setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

		JTextField campoNumero = new JTextField();
		JLabel numero = adicionarLabel("Número da Conta:");
		campoNumero.setPreferredSize(new Dimension(100, 30));
		add(numero);
		add(campoNumero);
		
		JTextField campoNumero2 = new JTextField();
		JLabel numero2 = adicionarLabel("Número da Conta de Destino:");
		campoNumero2.setPreferredSize(new Dimension(100, 30));
		add(numero2);
		add(campoNumero2);

		JTextField campoAgencia = new JTextField();
		JLabel agencia = adicionarLabel("Número da Agencia:");
		campoAgencia.setPreferredSize(new Dimension(70, 30));
		add(agencia);
		add(campoAgencia);

		JTextField campoValor = new JTextField();
		JLabel valor = adicionarLabel("Valor R$:");
		campoValor.setPreferredSize(new Dimension(70, 30));
		add(valor);
		add(campoValor);

		Botao botao = new Botao("Efetuar");
		botao.setPreferredSize(new Dimension(140, 40));
		botao.setBackground(new Color(183, 158, 20));

		add(botao);
		botao.addActionListener(event -> {
			if (naoVazio(campoAgencia.getText()))
				this.nroAgencia = campoAgencia.getText();
			if (naoVazio(campoNumero.getText()))
				this.nroConta = campoNumero.getText();
			if (naoVazio(campoValor.getText()))
				this.nroContaDes = campoNumero.getText();
			if (naoVazio(campoNumero2.getText()))
				this.valor = transformaStrDouble(campoValor.getText());

			if (this.valido) {
				efetuar();
			} else {
				new Alerta("Dados incorretos. Tente novamente!");
				this.telaAnt.dispose();
			}
		});
	}

	private void efetuar() {
		try {
			  Conta conta =  MemoriaConta.getInstancia().buscaConta(this.nroConta);
			  Conta contaDes =  MemoriaConta.getInstancia().buscaConta(this.nroContaDes);

		      Agencia agencia =  MemoriaAgencia.getInstancia().buscaAgencias(nroAgencia);
              
		      if(agencia == null || conta == null || contaDes == null) {
  				new Alerta("Erro. Dados incorretos! Agência ou conta não existe!");
              }
		      
		      else {
		    	  Transacao transacao = new Transacao(new Date(), conta, agencia, valor);
		    	  transacao.transferir(contaDes, valor);
		      }
		} catch (RuntimeException e) {
			new Alerta("Erro." + e.getMessage());
		}
	}

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

	private JLabel adicionarLabel(String labelText) {
		JLabel label = new JLabel(labelText);
		label.setFont(new Font("Courier", Font.BOLD, 16));
		return label;
	}

	private boolean naoVazio(String campo) {
		if (!campo.isEmpty()) {
			this.valido = this.valido && true;
			return true;
		} else {
			this.valido = false;
			return false;
		}
	}

}
